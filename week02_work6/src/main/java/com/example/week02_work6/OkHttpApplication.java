package com.example.week02_work6;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author: nhsoft.ll
 * @Description:
 * @Date:Create：2021-03-27 15:42
 * @Modified By：
 */
public class OkHttpApplication {
    public static void main(String[] args) throws Exception {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8801").build();
        Response response = okHttpClient.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
