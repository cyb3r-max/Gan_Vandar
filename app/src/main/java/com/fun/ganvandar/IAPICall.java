package com.fun.ganvandar;

import com.fun.ganvandar.Article.ArticleResponse;
import com.fun.ganvandar.Category.CategoryResponse;
import com.fun.ganvandar.User.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IAPICall {


    @POST("user/login")
    @FormUrlEncoded
// this line only for post method
    Call<UserResponse> login(
            @Field("username")  String username,
            @Field("password")  String password
    );


    @GET("blog/getAllCategories")
    Call<CategoryResponse> getAllCategories(
            @Header("Authorization")  String token
    );

    @POST("blog/5/0/getAllArticles")
    @FormUrlEncoded// this line only for post method
    Call<ArticleResponse> getAllArticles(
            @Header("Authorization")  String token,
            @Field("category_id")  String category_id
    );

}
