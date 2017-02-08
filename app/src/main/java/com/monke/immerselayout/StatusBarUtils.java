package com.monke.immerselayout;

import android.content.res.Resources;

/**
 * 创建人：章钦豪
 * 创建时间：2016/8/9
 * @version V1.0
 */
public class StatusBarUtils {
    private static int status_height = 0;

    public static int getStatusBarHeight() {
        try{
            status_height = Resources.getSystem().getDimensionPixelSize(
                    Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        }catch (Exception e){
            e.printStackTrace();
            status_height = 0;
        }
        return status_height;
    }

    public static int getStatus_height(){
        if(0 == status_height){
            status_height = getStatusBarHeight();
        }
        return status_height;
    }


    private static int navi_height = 0;

    public static int getNaviHeight(){
        try{
            navi_height = Resources.getSystem().getDimensionPixelSize(
                    Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
        }catch (Exception e){
            e.printStackTrace();
            navi_height = 0;
        }
        return navi_height;
    }

    public static int getNavi_height(){
        if(0 == navi_height){
            navi_height = getNaviHeight();
        }
        return navi_height;
    }
}
