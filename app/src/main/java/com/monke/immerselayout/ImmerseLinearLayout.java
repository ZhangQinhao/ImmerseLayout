package com.monke.immerselayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * 类描述：沉浸LinearLayout布局
 * 创建人：Monke
 * 创建时间：2017/1/17
 *
 * @version V1.0
 */
public class ImmerseLinearLayout extends LinearLayout implements IimmerseView {

    private ImmerseManager immerseManager;

    public ImmerseLinearLayout(Context context) {
        super(context);
        initManager(null);
    }

    public ImmerseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initManager(attrs);
    }

    @SuppressLint("NewApi")
    public ImmerseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initManager(attrs);
    }

    @SuppressLint("NewApi")
    public ImmerseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initManager(attrs);
    }

    public void initManager(AttributeSet attrs) {
        immerseManager = new ImmerseManager(this,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        immerseManager.onMeasureHeight(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }
}
