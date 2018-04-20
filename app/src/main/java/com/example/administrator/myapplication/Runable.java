package com.example.administrator.myapplication;


import com.example.imitateinput.ImitateInput;

/**
 * Created by Administrator on 2018/4/13.
 */

public class Runable implements Runnable {
    public static ImitateInput imitateInput = new ImitateInput();
    @Override
    public void run() {
        while (true){
            //CallMethod.Down(200,200);
            imitateInput.Down(100,100);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
