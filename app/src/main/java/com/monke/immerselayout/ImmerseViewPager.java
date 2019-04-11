package com.monke.immerselayout;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * 类描述：沉浸ViewPager布局
 * 创建人：章钦豪
 * 创建时间：2019/3/31
 * @version V1.0
 */
public class ImmerseViewPager extends ViewPager implements IimmerseView {
    private ImmerseManager immerseManager;

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
