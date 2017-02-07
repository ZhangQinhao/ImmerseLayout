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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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
public class MainActivity extends Activity{

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        bindView();
        bindEvent();
    }

    private void bindView() {
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
    }

    private void bindEvent() {
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BackgroundImmerActivity.class));
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImageImmerActivity.class));
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TabImmerActivity.class));
            }
        });
    }
}
