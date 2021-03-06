package com.anild.androidmvplogin.presenter;

import android.widget.Toast;

import com.anild.androidmvplogin.model.User;
import com.anild.androidmvplogin.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if (loginCode == 0) {
            loginView.onLoginError("You must enter your mail");
        } else if (loginCode == 1) {
            loginView.onLoginError("You must enter valid mail");
        } else if (loginCode == 2) {
            loginView.onLoginError("Password length must be greater than 6");
        } else {
            loginView.onLoginSuccess("Login success");
        }
        }
}
