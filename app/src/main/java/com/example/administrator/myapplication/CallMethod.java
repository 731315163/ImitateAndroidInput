package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/12.
 */

public class CallMethod {
    private static Context unityContext;
    private static Activity unityActivity;
    private static AlertDialog.Builder alert;
    private static List<View> views;
    //init方法，用来传入上下文
    public static void init(Context paramContext){
        Log.d("Call", "init: Init");
        unityContext = paramContext.getApplicationContext();
        unityActivity = (Activity) paramContext;
        views = getAllChildViews( unityActivity.getWindow().getDecorView());

    }
    public static void Down(int x,int y){
        Log.d("Call", "Down: ");
        final MotionEvent event = MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),
                MotionEvent.ACTION_DOWN, x, y, 0);
        unityActivity.runOnUiThread(new Runable(){
            @Override
            public void run(){

            }
        }
        );
        event.recycle();

    }
    //传入两个数返回他们的和
    public static int add(int arg0, int arg1){
        return arg0 + arg1;
    }

    //传入msg，弹出一个Toast提示
    public static void showMessage(final String msg){

        unityActivity.runOnUiThread(new Runnable()
        {
            public void run()
            {
                Toast.makeText(unityContext,msg, Toast.LENGTH_LONG).show();
            }
        });

    }

    //弹出一个提示窗口，窗口需要的文字信息从strings.xml里面获取，点击确认关闭
    public static void showAlertView(){

        alert = new AlertDialog.Builder(unityActivity).setTitle("弹出窗口").setMessage(unityContext.getResources().getIdentifier("msgAlert", "string", unityContext.getPackageName())).setPositiveButton("确认", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                unityActivity.finish();
            }
        });


        unityActivity.runOnUiThread(new Runnable()
        {
            public void run()
            {
                alert.show();
            }
        });
    }

    private static List<View> getAllChildViews(View view) {
        List<View> allchildren = new ArrayList<View>();
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            for (int i = 0; i < vp.getChildCount(); i++) {
                View viewchild = vp.getChildAt(i);
                Log.d("view", "view" + viewchild.toString());
                allchildren.add(viewchild);
                //再次 调用本身（递归）
                allchildren.addAll(getAllChildViews(viewchild));
            }
        }
        return allchildren;
    }
}