package com.monke.immerselayout;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

/**
 * 类描述：沉浸布局管理器
 * 创建人：Monke
 * 创建时间：2017/1/17
 *
 * @version V1.0
 */
public class ImmerseManager {
    private ViewGroup viewGroup;
    private ImmerseView immerseView;
    private boolean allImmerse = false;    //默认内部内容不沉浸  默认会设置paddingTop
    private boolean immerseNotchScreen = true;   //默认如果是异形屏 也要沉浸式

    private int paddingTop = 0;
    private int realHeight = 0;
    private FrameLayout rootView;

    public ImmerseManager(@NonNull ViewGroup viewGroup, AttributeSet attrs) {
        if (viewGroup instanceof ImmerseView) {
            this.viewGroup = viewGroup;
            this.immerseView = (ImmerseView) this.viewGroup;
            init(attrs);
        } else {
            throw new RuntimeException("Viewgroup并未实现IimmerseView接口");
        }
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = viewGroup.getContext().obtainStyledAttributes(attrs, R.styleable.ImmerseTitleLayout);
            allImmerse = typedArray.getBoolean(R.styleable.ImmerseTitleLayout_need_immerse, allImmerse);
            immerseNotchScreen = typedArray.getBoolean(R.styleable.ImmerseTitleLayout_need_immerse_notchscreen, immerseNotchScreen);
            typedArray.recycle();
        }
        paddingTop = viewGroup.getPaddingTop();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && (immerseNotchScreen || !StatusBarUtils.isNotchScreen(viewGroup.getContext()))) {
            Context context = viewGroup.getContext();
            if (context instanceof Activity) {
                rootView = ((Activity) context).findViewById(android.R.id.content);
                ((Activity) viewGroup.getContext()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                        WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                immerseView.setImmersePadding(viewGroup.getPaddingLeft(), getPaddingTop(paddingTop), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
            }
        }
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseView.setImmersePadding(left, getPaddingTop(top), right, bottom);
    }

    public MeasureHeightResult onMeasureHeight(int heightMeasureSpec) {
        MeasureHeightResult measureHeightResult = new MeasureHeightResult();
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int tempHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        if (viewGroup.getContext() != null && viewGroup.getContext() instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && (immerseNotchScreen || !StatusBarUtils.isNotchScreen(viewGroup.getContext()))
                && rootView.getChildAt(0) != viewGroup && heightMode == View.MeasureSpec.EXACTLY) {
            if (realHeight != tempHeight) {
                realHeight = tempHeight + StatusBarUtils.getStatus_height();
                measureHeightResult.setHeight(realHeight);
                measureHeightResult.setSuccess(true);
            }
        }
        return measureHeightResult;
    }

    private int getPaddingTop(int paddingtop) {
        paddingTop = paddingtop;
        if (viewGroup.getContext() != null && viewGroup.getContext() instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && !allImmerse
                && (immerseNotchScreen || !StatusBarUtils.isNotchScreen(viewGroup.getContext()))) {
            return paddingTop + StatusBarUtils.getStatus_height();
        } else {
            return paddingTop;
        }
    }
}