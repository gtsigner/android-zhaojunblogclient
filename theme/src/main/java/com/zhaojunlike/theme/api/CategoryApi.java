package com.zhaojunlike.theme.api;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhaojunlike.theme.entity.ApiReturn;
import com.zhaojunlike.theme.entity.Category;
import com.zhaojunlike.theme.entity.Document;
import com.zhaojunlike.theme.face.CallBackFunction;
import com.zhaojunlike.theme.utils.ApiUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/**
 * Created by zhaojunlike@ on 2016/6/23.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class CategoryApi {


    public static void getCategory(int pid, final CallBackFunction callback) {
        RequestParams params = new RequestParams(ApiUtil.APi_u_getCategorys);
        x.http().get(params, new Callback.CommonCallback<String>() {
                    private List<Category> categories = new ArrayList<Category>();
                    private int RETURN_TAG;

                    @Override
                    public void onSuccess(String result) {
                        //res JSon

                        Gson gson = new Gson();
                        ApiReturn ret = gson.fromJson(result, ApiReturn.class);
                        categories = gson.fromJson(gson.toJson(ret.getData()), new TypeToken<ArrayList<Category>>() {
                        }.getType());
                        this.RETURN_TAG = Api.API_STATUS_Success;
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        this.RETURN_TAG = Api.API_STATUS_Error;
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        this.RETURN_TAG = Api.API_STATUS_Cancel;
                    }

                    @Override
                    public void onFinished() {
                        callback.handleEvent(categories, this.RETURN_TAG);
                    }
                }

        );

    }
}
