package com.days.helloword;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context context;
    private TextView tv_text;
    private Button btn_dialog;
    private EditText edt_input;
    private Button btn_p_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        加载布局文件
        setContentView(R.layout.activity_main);
        context = this;
        initView();
        if (savedInstanceState != null) {
            edt_input.setText(savedInstanceState.getString("input"));
        }
    }

    private void initView() {
        tv_text = (TextView) findViewById(R.id.tv_text);
        btn_dialog = (Button) findViewById(R.id.btn_dialog);
        tv_text.setOnClickListener(this);
        btn_dialog.setOnClickListener(this);
        edt_input = (EditText) findViewById(R.id.edt_input);
        edt_input.setOnClickListener(this);
        btn_p_bar = (Button) findViewById(R.id.btn_p_bar);
        btn_p_bar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_text:
//                显示启动
//                Intent intent = new Intent();
//                intent.setClass(MainActivity.this, FristActivity.class);
//                startActivity(intent);
//                隐式启动
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.btn_dialog:
                startActivity(new Intent(context, DialogActivity.class));
                break;
            case R.id.btn_p_bar:
                startActivity(new Intent(context, FristActivity.class));
                break;
        }
    }

    private void submit() {
        // validate
        String input = edt_input.getText().toString().trim();
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(this, "临时文本", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String input = edt_input.getText().toString().trim();
        Log.v("input", input);
        outState.putString("input", input);
    }
}
