package com.sunkaisens.app.presenter;

import com.sunkaisens.androidutils.base.BaseActivity;
import com.sunkaisens.androidutils.base.BasePresenter;
import com.sunkaisens.app.contract.LoginContract;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:25
 * Description:
 */
public class LoginPresenter extends BasePresenter<LoginContract.View>implements LoginContract.Presenter {


    public LoginPresenter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public void login(String userName, String passWord) {

        if ("sunjianyun".equals(userName)&&"123456".equals(passWord)){
            getView().onSuccess();
        }else {
            getView().onFailed("用户名或密码错误");
        }
    }
}
