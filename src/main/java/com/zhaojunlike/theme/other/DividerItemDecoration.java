package com.zhaojunlike.theme.other;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by zhaojunlike@ on 2016/6/22.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    /**
     * 水平方向
     */
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    /**
     * 垂直方向
     */
    public static final int VERTICAL = LinearLayoutManager.VERTICAL;

    // 布局方向
    private int mOrientation;
    // 分割线颜色
    private int mColor;
    // 分割线尺寸
    private int mItemSize = 10;
    private Paint mPaint;

    public DividerItemDecoration(Context context) {
        super();
        mPaint = new Paint();
        mPaint.setColor(mColor);
        mPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * 画水平
     */
    protected void drawH(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mItemSize;

            c.drawRect(left, top, right, bottom, mPaint);
        }
    }

    /**
     * 画锤子
     */
    protected void drawV(Canvas c, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getMeasuredWidth() - parent.getPaddingRight();
        final int childSize = parent.getChildCount();
        for (int i = 0; i < childSize; i++) {
            final View child = parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + layoutParams.bottomMargin;
            final int bottom = top + mItemSize;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }


    /*设置颜色*/
    public void setColor(int color) {
        this.mColor = color;
    }

    /*设置大小*/
    public void setSize(int size) {
        this.mItemSize = size;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        if (this.mOrientation == VERTICAL) {
            drawH(c, parent);
        } else {
            drawV(c, parent);
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);


    }
}
