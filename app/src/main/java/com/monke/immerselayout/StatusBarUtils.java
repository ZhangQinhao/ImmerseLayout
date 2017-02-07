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

import android.content.res.Resources;

/**
 * <p/>
 * <p>类描述：</p>
 * <p>创建人：章钦豪</p>
 * <p>创建时间：2016/8/9</p>
 * <p>修改人：       </p>
 * <p>修改时间：   </p>
 * <p>修改备注：   </p>
 *
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
