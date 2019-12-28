package com.days.helloword;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.security.ProtectionDomain;

public class FristActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar pb_bar;
    private Button btn_add;
    private Button btn_paush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frist);
        initView();
    }

    private void initView() {
        pb_bar = (ProgressBar) findViewById(R.id.pb_bar);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_paush = (Button) findViewById(R.id.btn_paush);
        btn_paush.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                int progress = pb_bar.getProgress();
                progress = progress + 10;
                pb_bar.setProgress(progress);
                if (progress == 100) {
                    alertDialog();
                }
                break;
            case R.id.btn_paush:
//                new ProgressDialog(this).setTitle("刷新").setMessage("加载中。。。").setMess;
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Hello");
                progressDialog.setMessage("加载中。。。。");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
        }
    }

    private void alertDialog() {
        new AlertDialog.Builder(this).setTitle("提示")
                .setMessage("下载完成！").setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }
}
