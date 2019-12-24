package com.days.helloword;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        加载布局文件
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                显示启动
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, FristActivity.class);
//                startActivity(intent);
//                隐式启动
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
