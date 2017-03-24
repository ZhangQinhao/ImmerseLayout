package com.monke.immerselayout;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 类描述：沉浸布局管理器
 * 创建人：Monke
 * 创建时间：2017/1/17
 *
 * @version V1.0
 */
public class ImmerseManager {
    private ViewGroup viewGroup;
    private Boolean allImmerse = false;    //默认内部内容不沉浸  默认会设置paddingTop

    private int paddingTop = 0;
    private int height = 0;
    private int measureheight=0;
    private FrameLayout rootView;

    public ImmerseManager(ViewGroup viewGroup, AttributeSet attrs) {
        if (viewGroup instanceof IimmerseView) {
            this.viewGroup = viewGroup;
            init(attrs);
        } else {
            throw new RuntimeException("Viewgroup并未实现IimmerseView接口");
        }
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = viewGroup.getContext().obtainStyledAttributes(attrs, R.styleable.ImmerseTitleLayout);
            allImmerse = typedArray.getBoolean(R.styleable.ImmerseTitleLayout_need_immerse, allImmerse);
            typedArray.recycle();
        }
        paddingTop = viewGroup.getPaddingTop();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            rootView = (FrameLayout) ((Activity)viewGroup.getContext()).findViewById(android.R.id.content);
            ((Activity) viewGroup.getContext()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            viewGroup.setPadding(viewGroup.getPaddingLeft(), getPaddingTop(paddingTop), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        viewGroup.setPadding(left, getPaddingTop(top), right, bottom);
    }

    public void onMeasureHeight(int heightMeasureSpec){
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&rootView.getChildAt(0) != viewGroup && heightMode == View.MeasureSpec.EXACTLY && viewGroup.getMeasuredHeight()>0) {
            int sizeHeight = View.MeasureSpec.getSize(heightMeasureSpec);
            if(sizeHeight == viewGroup.getMeasuredHeight() && !allImmerse && height!= viewGroup.getMeasuredHeight()-StatusBarUtils.getStatus_height() && measureheight!= viewGroup.getMeasuredHeight()){
                height = sizeHeight;
                measureheight = viewGroup.getMeasuredHeight();
                viewGroup.getLayoutParams().height = height+StatusBarUtils.getStatus_height();
            }
        }
    }

    private int getPaddingTop(int paddingtop){
        paddingTop = paddingtop;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT &&!allImmerse){
            return paddingTop+StatusBarUtils.getStatus_height();
        }else {
            return paddingTop;
        }
    }
}