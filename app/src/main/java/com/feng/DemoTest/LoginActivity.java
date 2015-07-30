package com.feng.DemoTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dd.CircularProgressButton;


public class LoginActivity extends AppCompatActivity{

    com.dd.CircularProgressButton progressButton,getcodeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressButton= (CircularProgressButton) findViewById(R.id.btn_login_login);
        getcodeButton= (CircularProgressButton) findViewById(R.id.btn_login_getcode);
        progressButton.setIndeterminateProgressMode(true);
        getcodeButton.setIndeterminateProgressMode(true);
        progressButton.setOnClickListener(new MyTestClick(progressButton));
        getcodeButton.setOnClickListener(new MyTestClick(getcodeButton));



    }

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
