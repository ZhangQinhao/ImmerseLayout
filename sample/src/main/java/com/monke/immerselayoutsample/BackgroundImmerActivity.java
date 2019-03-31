package com.monke.immerselayoutsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建人：章钦豪
 * 创建时间：2017/2/7
 *
 * @version V1.0
 */
public class BackgroundImmerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!getIntent().getBooleanExtra("needImmerNotchScreen",true)){
            //异型屏不沉浸模式
            setContentView(R.layout.activity_backgroundimmer_notchscreen);
        }else{
            //异型屏也沉浸
            setContentView(R.layout.activity_backgroundimmer);
        }
    }
}
