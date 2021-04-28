package com.custom.moduleservice.proxy.stub;

import com.custom.moduleservice.proxy.core.ServiceTarget;

@ServiceTarget(value = "com.custom.moduleUser.login.LoginService")
public interface LoginServiceStub {

    void login(String name, String password, LoginCallback callback);

    interface LoginCallback {
        void onSuccess(LoginData data);

        void onFail(int code, String msg);
    }

    class LoginData {
        public String result;

        public LoginData(String result) {
            this.result = result;
        }
    }

}
