package com.sunkaisens.androidutils;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Copyright (C), 2015-2019, 北京视游互动科技有限公司
 * Author: sunjianyun
 * Date: 2019/8/29 17:24
 * Description:
 */
public interface ApiService {
    @GET("serviceabilities")
    Observable<String> getServiceAbilities();
}
