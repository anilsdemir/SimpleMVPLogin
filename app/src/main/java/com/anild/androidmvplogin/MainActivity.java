package com.anild.androidmvplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.anild.androidmvplogin.presenter.ILoginPresenter;
import com.anild.androidmvplogin.presenter.LoginPresenter;
import com.anild.androidmvplogin.view.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edt_mail, edt_password;
    Button btn_login;

    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_mail = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);
        btn_login = findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenter(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edt_mail.getText().toString(), edt_password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(getApplicationContext(),  message, Toasty.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(getApplicationContext(), message, Toasty.LENGTH_LONG).show();
    }
}
