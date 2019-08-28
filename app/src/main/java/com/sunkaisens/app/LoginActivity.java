package com.sunkaisens.app;

import android.os.Handler;
import android.view.View;

import com.sunkaisens.androidutils.base.BaseActivity;
import com.sunkaisens.androidutils.utils.SpUtils;
import com.sunkaisens.androidutils.utils.ToastUtil;
import com.sunkaisens.app.contract.LoginContract;
import com.sunkaisens.app.presenter.LoginPresenter;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:24
 * Description:
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {
    @Override
    protected void initView() {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void onSuccess() {

        ToastUtil.showToast("登录成功");

    }

    @Override
    public void onFailed(String reason) {
        ToastUtil.showToast("登录失败：" + reason);

    }

    public void login(View view) {
        presenter.login("sunjianyun", "123456");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
