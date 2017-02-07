/*
 * Copyright (C) 2016 ZED, Inc.
 *
 * This code contain confidential information from ZED Technologies Co.,Ltd.,
 * which is intended only for the person or entity whose address is listed above.
 * Any use of the information contained herein in any way  (including, but not limited to,
 * total or partial disclosure, reproduction, or dissemination)
 * by persons other than the intended recipient(s) is prohibited
 *
 */
package com.monke.immerselayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * <p>类描述：沉浸FrameLayout布局</p>
 * <p>创建人：Monke</p>
 * <p>创建时间：2017/1/17</p>
 *
 * @version V1.0
 */
public class ImmerseFrameLayout extends FrameLayout implements IimmerseView {

    private ImmerseManager immerseManager;

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
    public void setImmersePadding(int left, int top, int right, int bottom) {
        immerseManager.setImmersePadding(left,top,right,bottom);
    }

    @Override
    public void setImmerseLayoutParams(ViewGroup.LayoutParams params) {
        immerseManager.setImmerseLayoutParams(params);
    }
}