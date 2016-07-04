package com.zhaojunlike.theme.entity;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 * <p/>
 * 文章类
 */
public class Article extends Document {
    public int getBookmark() {
        return bookmark;
    }
    public void setBookmark(int bookmark) {
        this.bookmark = bookmark;
    }
    private int bookmark;

}
