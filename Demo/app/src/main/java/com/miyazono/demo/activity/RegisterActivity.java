package com.miyazono.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.miyazono.demo.R;
import com.miyazono.demo.service.RegisterService;

/**
 * Created by Administrator on 2017/12/24.
 */

public class RegisterActivity extends Activity {
    private EditText etaccount;
    private EditText etPassword;
    private EditText etname;
    private EditText etsex;
    private EditText etage;
    private EditText etidcard;
    private EditText ettel;
    private EditText etaddress;
    private Button btqd_register;
    private Button btqx_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etaccount = (EditText) findViewById(R.id.account_edit_text);
        etPassword = (EditText) findViewById(R.id.password_edit_text);
        etname = (EditText) findViewById(R.id.name_edit_text);
        etsex = (EditText) findViewById(R.id.sex_edit_text);
        etage = (EditText) findViewById(R.id.age_edit_text);
        etidcard = (EditText) findViewById(R.id.idcard_edit_text);
        ettel = (EditText) findViewById(R.id.tel_edit_text);
        etaddress = (EditText) findViewById(R.id.address_edit_text);
        btqd_register = (Button) findViewById(R.id.qd_register_button);
        btqx_register = (Button) findViewById(R.id.qx_register_button);
        final String account = etaccount.getText().toString().trim();
        final String password = etPassword.getText().toString().trim();
        final String name = etname.getText().toString().trim();
        final String sex = etsex.getText().toString().trim();
        final String age = etage.getText().toString().trim();
        final String idcard = etidcard.getText().toString().trim();
        final String tel = ettel.getText().toString().trim();
        final String address = etaddress.getText().toString().trim();

//                final UserBean user = new UserBean();
//                user.setUserName(username);
//                user.setPassword(password);
//                RegisterService.RegisterByPost(user);
        btqd_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    public void run(){
                        final String result = RegisterService.RegisterByPost(account,password,name,sex,age,idcard,tel,address);
                        if(result != null){
                            //ui线程更改界面
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,result,0).show();
                                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }else{
                            //请求失败，弹出toast
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,"请求失败......",0).show();
                                }
                            });
                        }
                    }
                }.start();
            }
        });

        btqx_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

}
