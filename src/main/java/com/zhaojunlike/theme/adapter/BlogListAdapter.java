package com.zhaojunlike.theme.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


import com.zhaojunlike.theme.R;
import com.zhaojunlike.theme.entity.Article;
import com.zhaojunlike.theme.entity.Document;
import com.zhaojunlike.theme.utils.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 * <p/>
 * 博客列表的适配器
 */
public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.RecyclerViewViewHolder> {

    private Context mContext;
    private List<Document> mBlogs;

    public BlogListAdapter(Context context, List<Document> blogs) {
        this.mContext = context;
        this.mBlogs = blogs;
    }

    /**
     * 设置新的数据源，提醒adatper更新
     *
     * @param blogs
     */
    public void refreshData(List<Document> blogs) {
        this.mBlogs = blogs;
        this.notifyDataSetChanged();
    }


    /**
     * 创建ViewHolder
     *
     * @param viewGroup
     * @param i
     * @return
     */
    @Override
    public RecyclerViewViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_bloglist, viewGroup, false);
        return new RecyclerViewViewHolder(view);
    }

    /**
     * 绑定数据
     *
     * @param viewholder
     * @param i
     */
    @Override
    public void onBindViewHolder(RecyclerViewViewHolder viewholder, int i) {

        viewholder.mTitle.setText(mBlogs.get(i).getTitle());
        viewholder.mDescription.setText(mBlogs.get(i).getDescription());
//        viewholder.mCommentCount.setText(mBlogs.get(i).getComment());
        viewholder.mViewCount.setText(mBlogs.get(i).getView() + "");
        //处理日期特殊格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date(Integer.parseInt(mBlogs.get(i).getCreate_time()) * 1000L));
        viewholder.mTime.setText(date);
    }

    @Override
    public int getItemCount() {
        return mBlogs.size();
    }

    /**
     * 自定义ViewHolder
     */
    public static class RecyclerViewViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;//标题
        private TextView mDescription;//描述
        private TextView mTime;//发表时间
        private TextView mCommentCount;//评论量
        private TextView mViewCount;//访问量

        public RecyclerViewViewHolder(View view) {
            super(view);
            mTitle = (TextView) view.findViewById(R.id.bloglist_tv_title);
            mDescription = (TextView) view.findViewById(R.id.bloglist_tv_description);
            mTime = (TextView) view.findViewById(R.id.bloglist_tv_time);
            mCommentCount = (TextView) view.findViewById(R.id.bloglist_tv_comment);
            mViewCount = (TextView) view.findViewById(R.id.bloglist_tv_view);
        }

    }
}