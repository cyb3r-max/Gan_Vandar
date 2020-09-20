package com.fun.ganvandar.Category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fun.ganvandar.Article.ArticleListActivity;
import com.fun.ganvandar.IAPICall;
import com.fun.ganvandar.Preference;
import com.fun.ganvandar.R;
import com.fun.ganvandar.RetrofitFactory;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryListActivity extends AppCompatActivity implements ICallBack{

    RecyclerView rvCategoryList;
    List<Category> categoryList = new ArrayList<>();
    Preference preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        preferences = new Preference(this);


        rvCategoryList = findViewById(R.id.rvCategoryList);
        rvCategoryList.setLayoutManager(new LinearLayoutManager(this));

       /* String token = new Preference(CategoryListActivity.this).getToken();*/

        IAPICall iApiCall =
                RetrofitFactory.getRetrofit().create(IAPICall.class);

        Call<CategoryResponse> categoyResponseCall = iApiCall.getAllCategories(new Preference(CategoryListActivity.this).getToken());
        categoyResponseCall.enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                CategoryResponse categoyResponse = response.body();
                categoryList = categoyResponse.getData();
                rvCategoryList.setAdapter(new CategoryListAdapter(categoryList, CategoryListActivity.this));
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                t.getMessage();
            }
        });

    }

    @Override
    public <T> void callBack(T t) {
        Category category =  (Category) t;

        Intent intent =  new Intent(CategoryListActivity.this, ArticleListActivity.class);
        startActivity(intent);
    }
}
