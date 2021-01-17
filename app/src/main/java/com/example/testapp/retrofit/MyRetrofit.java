package com.example.testapp.retrofit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class MyRetrofit {

    private static Retrofit retrofit ;

    public synchronized static Retrofit getRetrofit() {

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().
                    baseUrl("https://jsonplaceholder.typicode.com/").
                    addConverterFactory(GsonConverterFactory.create()).
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                    build();

        }
        return retrofit ;
    }
    public static MyCalls getConnection()
    {
        return getRetrofit().create(MyCalls.class);
    }
}
