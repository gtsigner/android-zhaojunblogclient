package com.zhaojunlike.theme.app;

import android.app.Application;

import com.zhaojunlike.theme.BuildConfig;

import org.xutils.x;

/**
 * Created by zhaojunlike@ on 2016/6/22.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class BlogApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        /*初始化utils*/
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
}
