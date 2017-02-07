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
package com.monke.immerselayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * <p>版权所有：2016-深圳市得色科技有限公司</p>
 * <p/>
 * <p>类描述：</p>
 * <p>创建人：章钦豪</p>
 * <p>创建时间：2017/2/7</p>
 * <p>修改人：       </p>
 * <p>修改时间：   </p>
 * <p>修改备注：   </p>
 *
 * @version V1.0
 */
public class ImageImmerActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_imageimmer);
    }
}
