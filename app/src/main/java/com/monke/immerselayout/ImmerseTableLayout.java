package com.monke.immerselayout;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
/**
 * 类描述：沉浸TableLayout布局
 * 创建人：章钦豪
 * 创建时间：2017/2/7
 * @version V1.0
 */
public class ImmerseTableLayout extends TableLayout implements IimmerseView{

    private ImmerseManager immerseManager;

    public ImmerseTableLayout(Context context) {
        super(context);
        initManager(null);
    }

    public ImmerseTableLayout(Context context, AttributeSet attrs) {
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