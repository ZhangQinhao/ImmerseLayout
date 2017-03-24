package com.monke.immerselayout;

import android.content.Context;
import android.support.annotation.Px;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TableLayout;

/**
 * 类描述：沉浸RelativeLayout布局
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
        immerseManager.onMeasureHeight(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }
}
