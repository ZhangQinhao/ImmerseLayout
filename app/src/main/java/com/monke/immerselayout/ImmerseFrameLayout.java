package com.monke.immerselayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/**
 * 类描述：沉浸FrameLayout布局
 * 创建人：Monke
 * 创建时间：2017/1/17
 *
 * @version V1.0
 */
public class ImmerseFrameLayout extends FrameLayout implements IimmerseView {

    protected ImmerseManager immerseManager;

    public ImmerseFrameLayout(Context context) {
        super(context);
        initManager(null);
    }

    public ImmerseFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initManager(attrs);
    }

    public ImmerseFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initManager(attrs);
    }

    @SuppressLint("NewApi")
    public ImmerseFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initManager(attrs);
    }

    public void initManager(AttributeSet attrs){
        immerseManager = new ImmerseManager(this,attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int resultHeight =  immerseManager.onMeasureHeight(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(resultHeight>0){
            setMeasuredDimension(widthMeasureSpec, resultHeight);
            getLayoutParams().height = resultHeight;
        }
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }
}