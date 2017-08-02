package com.example.huangdouya.mymusicapplication.utils;

import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

/**
 * Created by huangdouya on 2017/8/2.
 */
public class AnyHelper {

    /**
     * 自定义log 信息打印
     */
    private static final int VERBOSE = 1;
    private static final int DEBUG = 2;
    private static final int INFO = 3;
    private static final int WARN = 4;
    private static final int ERROR = 5;
    private static final int NOTHING = 6;
    private static int lever = 1;
    public static void logv(String tag,String msg){
        if(lever <= VERBOSE){
            Log.v(tag,msg);
        }
    }
    public static void logd(String tag,String msg){
        if(lever <= DEBUG){
            Log.d(tag,msg);
        }
    }
    public static void logi(String tag,String msg){
        if(lever <= INFO){
            Log.i(tag,msg);
        }
    }
    public static void logw(String tag,String msg){
        if(lever <= WARN){
            Log.w(tag,msg);
        }
    }
    public static void loge(String tag,String msg){
        if(lever <= ERROR){
            Log.e(tag,msg);
        }
    }
}
