package com.zhaojunlike.theme.api;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.zhaojunlike.theme.adapter.BlogListAdapter;
import com.zhaojunlike.theme.entity.ApiReturn;
import com.zhaojunlike.theme.entity.Category;
import com.zhaojunlike.theme.entity.Document;
import com.zhaojunlike.theme.entity.Download;
import com.zhaojunlike.theme.face.CallBackFunction;
import com.zhaojunlike.theme.utils.ApiUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class DocumentApi extends Api {

    private static String uri;
    private static String LOG_TAG = "DocumentAPI";

    static {
        DocumentApi.uri = ApiUtil.API_u_getDocuments;
    }

    public static void getDocumentByCategory(Category cate, int p, int count, final CallBackFunction func) {

        final RequestParams params = new RequestParams(uri);

        if (cate.getId() != 0) {
            params.addQueryStringParameter("cat_id", cate.getId() + "");
        }
        if (cate.getName() != null) {
            params.addQueryStringParameter("cat_name", cate.getName());
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            private List<Document> docList = new ArrayList<Document>();

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ApiReturn ret = gson.fromJson(result, ApiReturn.class);
                docList = gson.fromJson(gson.toJson(ret.getData()), new TypeToken<ArrayList<Document>>() {
                }.getType());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(LOG_TAG, "onError:" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(LOG_TAG, "onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e(LOG_TAG, "onFinished");
                func.handleEvent(docList, API_STATUS_Success);//回传数据让他自己处理
            }
        });
    }

    public static void getDocumentHot(int p, int count, final CallBackFunction func) {
        final RequestParams params = new RequestParams(ApiUtil.API_u_getHotArticle);
        x.http().get(params, new Callback.CommonCallback<String>() {
            private List<Document> docList = new ArrayList<Document>();

            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                ApiReturn ret = gson.fromJson(result, ApiReturn.class);
                docList = gson.fromJson(gson.toJson(ret.getData()), new TypeToken<ArrayList<Document>>() {
                }.getType());

                for (int i = 0; i < docList.size(); i++) {
                    System.out.println(docList.get(i).getView() + "");
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(LOG_TAG, "onError:" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(LOG_TAG, "onCancelled");
            }

            @Override
            public void onFinished() {
                Log.e(LOG_TAG, "onFinished");
                func.handleEvent(docList, API_STATUS_Success);//回传数据让他自己处理
            }
        });
    }

}
