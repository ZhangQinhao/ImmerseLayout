package com.monke.immerselayout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

public class ImmerseViewPager extends ViewPager implements IimmerseView {
    protected ImmerseManager immerseManager;

    public ImmerseViewPager(Context context) {
        super(context);
        initManager(null);
    }

    public ImmerseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
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

    @Override
    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }
}
