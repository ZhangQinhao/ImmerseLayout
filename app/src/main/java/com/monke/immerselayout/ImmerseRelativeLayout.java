package com.monke.immerselayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 类描述：沉浸RelativeLayout布局
 * 创建人：章钦豪
 * 创建时间：2017/2/7
 * @version V1.0
 */
public class ImmerseRelativeLayout extends RelativeLayout implements IimmerseView{

    private ImmerseManager immerseManager;

    public ImmerseRelativeLayout(Context context) {
        super(context);
        initManager(null);
    }

    public ImmerseRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initManager(attrs);
    }

    public ImmerseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initManager(attrs);
    }

    public void initManager(AttributeSet attrs){
        immerseManager = new ImmerseManager(this,attrs);
    }

    @SuppressLint("NewApi")
    public ImmerseRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        MeasureHeightResult resultHeight =  immerseManager.onMeasureHeight(heightMeasureSpec);
        if(resultHeight.isSuccess()){
            setMeasuredDimension(widthMeasureSpec, resultHeight.getHeight());
            getLayoutParams().height = resultHeight.getHeight();
        }
        super.onMeasure(widthMeasureSpec, resultHeight.isSuccess()?resultHeight.getHeight():heightMeasureSpec);
    }

    @Override
    public void setPadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }

    @Override
    public void setImmersePadding(int left, int top, int right, int bottom) {
        super.setPadding(left,top,right,bottom);
    }
}