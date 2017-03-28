package com.monke.immerselayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.monke.immerselayout.ImmerseLinearLayout;

/**
 * 创建人：Monke
 * 创建时间：2017/2/7
 *
 * @version V1.0
 */
public class TabImmerActivity extends Activity{
    private Boolean a = false;
    private ImmerseLinearLayout abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tabimmer);
        abc = (ImmerseLinearLayout) findViewById(R.id.abc);
        findViewById(R.id.a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!a){
                    ViewGroup.LayoutParams layoutParams = abc.getLayoutParams();
                    layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    abc.setLayoutParams(layoutParams);
                    a = true;
                }else{
                    ViewGroup.LayoutParams layoutParams = abc.getLayoutParams();
                    layoutParams.height = 900;
                    abc.setLayoutParams(layoutParams);
                    a = false;
                }
            }
        });
    }
}
