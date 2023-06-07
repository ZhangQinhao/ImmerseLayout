package com.monke.immerselayoutsample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 创建人：章钦豪
 * 创建时间：2017/2/7
 *
 * @version V1.0
 */
public class ColorImmerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(!getIntent().getBooleanExtra("needImmerNotchScreen",true)){
            //异型屏不沉浸模式
            setContentView(R.layout.activity_colorimmer_notchscreen);
        }else{
            //异型屏也沉浸
            setContentView(R.layout.activity_colorimmer);
        }
    }
}
