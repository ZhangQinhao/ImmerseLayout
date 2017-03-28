package com.monke.immerselayout;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
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
    private int realHeight = 0;
    private Boolean isMatch = false;
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
            rootView = (FrameLayout) ((Activity) viewGroup.getContext()).findViewById(android.R.id.content);
            ((Activity) viewGroup.getContext()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            viewGroup.setPadding(viewGroup.getPaddingLeft(), getPaddingTop(paddingTop), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        }
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        viewGroup.setPadding(left, getPaddingTop(top), right, bottom);
    }

    public int onMeasureHeight(int heightMeasureSpec) {
        int result = -1;
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int tempHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && rootView.getChildAt(0) != viewGroup && heightMode == View.MeasureSpec.EXACTLY && viewGroup.getMeasuredHeight() > 0) {
            if(viewGroup.getMeasuredHeight()!=tempHeight && !isMatch){
                isMatch = true;
            }else{
                if (realHeight != tempHeight && !isMatch) {
                    realHeight = tempHeight + StatusBarUtils.getStatus_height();
                    result = realHeight;
                }
            }
        }
        return result;
    }

    private int getPaddingTop(int paddingtop) {
        paddingTop = paddingtop;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && !allImmerse) {
            return paddingTop + StatusBarUtils.getStatus_height();
        } else {
            return paddingTop;
        }
    }

    public Boolean getAllImmerse() {
        return allImmerse;
    }

    public void setAllImmerse(Boolean allImmerse) {
        this.allImmerse = allImmerse;
    }
}