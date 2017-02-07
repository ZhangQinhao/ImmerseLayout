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

import android.view.ViewGroup;

/**
 * <p>类描述：沉浸布局必要接口</p>
 * <p>创建人：Monke</p>
 * <p>创建时间：2017/1/17</p>
 * @version V1.0
 */
public interface IimmerseView {

    void setImmersePadding(int left, int top, int right, int bottom);

    void setImmerseLayoutParams(ViewGroup.LayoutParams params);
}
