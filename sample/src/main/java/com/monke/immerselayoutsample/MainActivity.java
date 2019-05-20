package com.monke.immerselayoutsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.monke.immerselayout.StatusBarUtils;

/**
 * 创建人：Monke
 * 创建时间：2017/2/7
 *
 * @version V1.0
 */
public class MainActivity extends Activity{

    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;

    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setDarkMode(this); //设置状态栏字体颜色
        setContentView(R.layout.activity_main);

        bindView();
        bindEvent();
    }

    private void bindView() {
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);

        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
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
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ColorImmerActivity.class));
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BackgroundImmerActivity.class);
                intent.putExtra("needImmerNotchScreen",false);
                startActivity(intent);
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImageImmerActivity.class);
                intent.putExtra("needImmerNotchScreen",false);
                startActivity(intent);
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabImmerActivity.class);
                intent.putExtra("needImmerNotchScreen",false);
                startActivity(intent);
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ColorImmerActivity.class);
                intent.putExtra("needImmerNotchScreen",false);
                startActivity(intent);
            }
        });
    }
}
