package com.feng.DemoTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.CircularProgressButton;

import me.drakeet.materialdialog.MaterialDialog;

public class InfoActivity extends AppCompatActivity {
    com.dd.CircularProgressButton logoutBTN;
    MaterialDialog mMaterialDialog;
    MaterialDialog commentDialog;
    RelativeLayout commentRL;
    RelativeLayout changePWD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        commentRL= (RelativeLayout) findViewById(R.id.rl_info_comment);
        //mdDialog
        mMaterialDialog = new MaterialDialog(this).setTitle("确认退出？").setPositiveButton("注销", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this, LoginActivity.class));
                InfoActivity.this.finish();

            }
        }).setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMaterialDialog.dismiss();
                logoutBTN.setProgress(0);
            }
        }).setMessage("退出后将接收不到推送");
        //dialog
        View comment= View.inflate(this, R.layout.commentialog, null);
        final EditText mycomment= (EditText) comment.findViewById(R.id.et_comment);
        mycomment.setFocusable(true);
        mycomment.setFocusableInTouchMode(true);
        mycomment.requestFocus();
        commentDialog=new MaterialDialog(this).setContentView(comment).setPositiveButton("提交评论", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(InfoActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                Toast.makeText(InfoActivity.this, mycomment.getText().toString(), Toast.LENGTH_SHORT).show();
                commentDialog.dismiss();
            }
        }).setNegativeButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog.dismiss();
            }
        }).setTitle("意见反馈");
        commentRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentDialog.show();
            }
        });

        changePWD= (RelativeLayout) findViewById(R.id.rl_info_account);
        changePWD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoActivity.this,ChangePasswordActivity.class));
            }
        });


        logoutBTN= (CircularProgressButton) findViewById(R.id.btn_info_logout);
        logoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutBTN.setIndeterminateProgressMode(true);
                logoutBTN.setProgress(2);
                mMaterialDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_info, menu);
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
}
