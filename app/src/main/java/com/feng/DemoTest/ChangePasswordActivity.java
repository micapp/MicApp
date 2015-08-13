package com.feng.DemoTest;

import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.dd.CircularProgressButton;

public class ChangePasswordActivity extends AppCompatActivity {
    CircularProgressButton confirmPWD;
    EditText password1,password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        confirmPWD = (CircularProgressButton) findViewById(R.id.btn_changepassword_confirmchange);
        password1 = (EditText) findViewById(R.id.et_changepassword_newpwd1);
        password2 = (EditText) findViewById(R.id.et_changepassword_newpwd2);
        password1.addTextChangedListener(textWatcher);
        password2.addTextChangedListener(textWatcher);

    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!password1.getText().toString().equals(password2.getText().toString()))
            {
                confirmPWD.setProgress(-1);
                confirmPWD.setText("新旧密码不一致");
            }
            else
                confirmPWD.setProgress(0);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
