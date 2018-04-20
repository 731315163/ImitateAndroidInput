package com.example.administrator.myapplication;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
     public static Activity current;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("开始","Hello World");
        current = this;
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.d("点击","Sucess");
            }
        });

        String[] datastr = new String[100];
        for (int i = 0; i <100 ; i++) {
            datastr[i] = Integer.toString(i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,datastr);
        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);
        CallMethod.init(this);
        ImitateInputTest imi = new ImitateInputTest();
        imi.Start();

    }




}