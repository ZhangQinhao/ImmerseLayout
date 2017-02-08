package com.monke.immerselayout;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * 类描述：沉浸布局管理器
 * 创建人：Monke
 * 创建时间：2017/1/17
 * @version V1.0
 */
public class ImmerseManager {
    private ViewGroup viewGroup;
    private ImmerseGlobalLayoutListener immerseGlobalLayoutListener;
    private Boolean allImmerse = false;    //默认内部内容不沉浸  默认会设置paddingTop

    public ImmerseManager(ViewGroup viewGroup, AttributeSet attrs) {
        if (viewGroup instanceof IimmerseView) {
            this.viewGroup = viewGroup;
            init(attrs);
        } else {
            throw new RuntimeException("Viewgroup并未实现IimmerseView接口");
        }
    }

    private void init(AttributeSet attrs) {
        if(attrs!=null){
            TypedArray typedArray = viewGroup.getContext().obtainStyledAttributes(attrs, R.styleable.ImmerseTitleLayout);
            allImmerse = typedArray.getBoolean(R.styleable.ImmerseTitleLayout_need_immerse, allImmerse);
            typedArray.recycle();
        }

        immerseGlobalLayoutListener = new ImmerseGlobalLayoutListener();
        updateView();
    }

    public void setImmersePadding(int left, int top, int right, int bottom) {
        updateView();
        viewGroup.setPadding(left, top, right, bottom);
    }

    public void setImmerseLayoutParams(ViewGroup.LayoutParams params) {
        updateView();
        viewGroup.setLayoutParams(params);
    }

    /**
     * view首次实例化 或者 修改前更新调用
     */
    public void updateView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ((Activity) viewGroup.getContext()).getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(immerseGlobalLayoutListener);
        }
    }

    /**
     * 绘制完成监听器
     */
    class ImmerseGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

        @Override
        public void onGlobalLayout() {
            if (viewGroup != null && viewGroup instanceof IimmerseView) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                FrameLayout content = (FrameLayout) ((Activity) viewGroup.getContext()).findViewById(android.R.id.content);
                int height = viewGroup.getHeight();
                if (content.getChildAt(0) instanceof IimmerseView && content.getChildAt(0) == viewGroup || (layoutParams.height <= 0 && allImmerse)) {
                    layoutParams.height = height;
                } else {
                    layoutParams.height = height + StatusBarUtils.getStatus_height();
                }
                viewGroup.setLayoutParams(layoutParams);

                int immPadding = 0;
                if (!allImmerse)
                    immPadding = StatusBarUtils.getStatus_height();
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop() + immPadding, viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        }
    }
}