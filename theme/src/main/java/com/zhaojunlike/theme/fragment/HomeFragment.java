package com.zhaojunlike.theme.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zhaojunlike.theme.R;
import com.zhaojunlike.theme.adapter.BlogListAdapter;
import com.zhaojunlike.theme.api.Api;
import com.zhaojunlike.theme.api.DocumentApi;
import com.zhaojunlike.theme.entity.Category;
import com.zhaojunlike.theme.entity.Document;
import com.zhaojunlike.theme.face.CallBackFunction;
import com.zhaojunlike.theme.other.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 * <p/>
 * 主页
 */
public class HomeFragment extends Fragment {

    private View mView;
    //下拉刷新
    private SwipeRefreshLayout mSwipeRefreshLayout;
    //无限滚动

    private RecyclerView mRecyclerView;
    private BlogListAdapter mBlogListAdapter;
    private List<Document> mDocumnetsList;
    private int mCurrentPage = 1;
    private boolean isLoadding = false;
    private int mLimitCount = 15;//每页获取的数量

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.mView = inflater.inflate(R.layout.fragment_home, null);
        this.initView();
        this.initData();
        this.initAction();
        //初始化数据
        this.mSwipeRefreshLayout.setRefreshing(true);
        getData(mCurrentPage, mLimitCount);
        return this.mView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void initAction() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isLoadding == false) {
                    mCurrentPage = 1;//上拉刷新初始化分页
                    getData(mCurrentPage, mLimitCount);
                }
            }
        });

    }

    private void initData() {

        this.mDocumnetsList = new ArrayList<Document>();
        this.mBlogListAdapter = new BlogListAdapter(this.getContext(), this.mDocumnetsList);
        this.mRecyclerView.setAdapter(this.mBlogListAdapter);


    }

    private void initView() {
        this.mRecyclerView = (RecyclerView) this.mView.findViewById(R.id.rv_list);//获取列表控件
        this.mSwipeRefreshLayout = (SwipeRefreshLayout) this.mView.findViewById(R.id.swipe_refresh);
        //设置下拉刷新的颜色
        this.mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        //设置显示样式
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext());
        dividerItemDecoration.setColor(Color.BLACK);
        this.mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    /**
     * 获取数据
     *
     * @param p
     * @param count
     */
    public void getData(int p, int count) {

        Category cat = new Category();
        cat.setId(0);//顶级分类
        /**
         *  获取文档信息
         */
        DocumentApi.getDocumentByCategory(cat, mCurrentPage, mLimitCount, new CallBackFunction() {
            @Override
            public void handleEvent(Object data, int what) {
                if (what == Api.API_STATUS_Success) {
                    List<Document> docList = (ArrayList<Document>) data;//
                    mBlogListAdapter.refreshData(docList);
                    Toast.makeText(getContext(), "数据已刷新", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "对不起,没有更多数据了!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.mSwipeRefreshLayout.setRefreshing(false);
    }
}
