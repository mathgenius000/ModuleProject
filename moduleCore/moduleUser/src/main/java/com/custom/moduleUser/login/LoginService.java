package com.custom.moduleUser.login;

import com.custom.moduleservice.proxy.stub.LoginServiceStub;

/**
 * 登陆服务
 */
public class LoginService implements LoginServiceStub {

    @Override
    public void login(String name, String password, LoginCallback callback) {
        if (System.currentTimeMillis() % 2 == 0) {
            callback.onSuccess(new LoginData("登录成功"));
        } else {
            callback.onFail(-1, "登录失败");
        }
    }

}
