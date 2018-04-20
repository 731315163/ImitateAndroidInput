package com.example.imitateinput;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2018/4/11.
 */

public class ImitateMove implements Runnable {
    private int x,y;
    public ImitateMove(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void run(){
         ImitateInput.inst.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),
                MotionEvent.ACTION_MOVE, x, y, 0));
    }
}
