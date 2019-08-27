package com.sunkaisens.app.contract;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/27 20:25
 * Description:
 */
public interface LoginContract {
    interface Model {
    }

    interface View {
        void onSuccess();

        void onFailed(String reason);
    }

    interface Presenter {
        void login(String userName, String passWord);
    }
}
