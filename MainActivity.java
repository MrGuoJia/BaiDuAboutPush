package com.example.jia.baidupush;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        autoBindBaiduYunTuiSong();
    }

    private void autoBindBaiduYunTuiSong() {
        PushManager.startWork(getApplicationContext(),PushConstants.LOGIN_TYPE_API_KEY,"AVdvW9tkOXQmdZH2TLwjvNAX");
    }

    private void initViews() {
        tv= (TextView) findViewById(R.id.tv_msg);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        String result = intent.getStringExtra("result");
        if(result!=null){
            tv.setText(result);
        }
    }
}
