package com.example.imitateinput;

import android.app.Instrumentation;
import android.util.Log;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/11.
 */

public class ImitateInput {
    public static Instrumentation inst = new Instrumentation();
    private static ThreadPoolExecutor threadpool  = new ThreadPoolExecutor(1,1,3, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(1000),new ThreadPoolExecutor.DiscardPolicy());


    public void Down(int x,int y){
        try {
            threadpool.execute(new ImitateDown(x,y));
        }catch (Exception e){
            Log.e("ImitateTouch",e.toString());
        }
    }
    public void Move(int x,int y){
        try {
            threadpool.execute(new ImitateMove(x,y));
        }catch (Exception e){
            Log.e("ImitateTouch",e.toString() );
        }
    }
    public void Up(int x,int y){
        try {
            threadpool.execute(new ImitateUp(x,y));
        }
        catch (Exception e){
            Log.e("ImitateTouch", e.toString() );
        }

    }
}