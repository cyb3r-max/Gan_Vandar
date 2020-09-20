package com.fun.ganvandar;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

    public static Retrofit getRetrofit() {

        return new Retrofit.Builder()
                .baseUrl("http://nurhossen.info/appsHill/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
