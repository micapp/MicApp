package com.feng.DemoTest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.dd.CircularProgressButton;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;


public class LoginActivity extends AppCompatActivity{

    com.dd.CircularProgressButton progressButton,getcodeButton;
    EditText phoneNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // String phoneNumber="";
        XGPushConfig.enableDebug(this, true);
        phoneNum=(EditText)findViewById(R.id.et_login_phone);
        progressButton= (CircularProgressButton) findViewById(R.id.btn_login_login);
        getcodeButton= (CircularProgressButton) findViewById(R.id.btn_login_getcode);
        progressButton.setIndeterminateProgressMode(true);
        getcodeButton.setIndeterminateProgressMode(true);
        // progressButton.setOnClickListener(new MyTestClick(progressButton));
        getcodeButton.setOnClickListener(new MyTestClick(getcodeButton));
        progressButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                progressButton.setProgress(50);
                String phoneNumber =phoneNum.getText().toString();
                final Context context = getApplicationContext();
                //registerPush(Context context, String account)
                XGPushManager.registerPush(context,phoneNumber, new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object data, int flag) {
                        Toast.makeText(context,"注册成功", Toast.LENGTH_SHORT).show();
                        progressButton.setProgress(100);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        startActivity(new Intent(LoginActivity.this,MessageActivity.class));
                    }

                    @Override
                    public void onFail(Object data, int errCode, String msg) {
                        Toast.makeText(context,"注册失败", Toast.LENGTH_SHORT).show();
                        progressButton.setProgress(-1);
                    }
                });

            }
        });

    }

    /*public void onUnregisterResult(Context context, int errorCode) {
        if (context == null) {
            return;
        }
        String text = "";
        if (errorCode == XGPushBaseReceiver.SUCCESS) {
            text = "反注册成功";
        } else {
            text = "反注册失败" + errorCode;
        }
      // Log.d(LogTag, text);
       // show(context, text);
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class MyTestClick implements View.OnClickListener{
        CircularProgressButton cpBtn;

        public MyTestClick(CircularProgressButton cpBtn) {
            this.cpBtn = cpBtn;
        }

        @Override
        public void onClick(View v) {
            if (cpBtn.getProgress() == 0) {
                cpBtn.setProgress(50);
            } else if (cpBtn.getProgress() == 100) {
                cpBtn.setProgress(0);
            } else {
                cpBtn.setProgress(100);
            }
        }
    }
}
