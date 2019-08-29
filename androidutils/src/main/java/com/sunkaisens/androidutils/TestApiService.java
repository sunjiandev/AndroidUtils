package com.sunkaisens.androidutils;

import com.sunkaisens.androidutils.base.DefaultSubscriber;
import com.sunkaisens.androidutils.utils.HttpClient;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/29 17:26
 * Description:
 */
public class TestApiService {
    public void test() {
        HttpClient.getHttpClient().getRetrofit().create(ApiService.class)
                .getServiceAbilities()
                .subscribe(new DefaultSubscriber<String>() {
                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
    }
}
