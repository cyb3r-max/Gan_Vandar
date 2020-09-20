package com.fun.ganvandar.Article;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fun.ganvandar.Category.CategoryListActivity;
import com.fun.ganvandar.Category.CategoryListAdapter;
import com.fun.ganvandar.Category.CategoryResponse;
import com.fun.ganvandar.IAPICall;
import com.fun.ganvandar.Preference;
import com.fun.ganvandar.R;
import com.fun.ganvandar.RetrofitFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleListActivity extends AppCompatActivity {

    RecyclerView rvArticleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);



        rvArticleList = findViewById(R.id.rvArticleList);
        rvArticleList.setLayoutManager(new LinearLayoutManager(this));

        IAPICall iApiCall = RetrofitFactory.getRetrofit().create(IAPICall.class);

        Call<ArticleResponse> articleResponsCall = iApiCall.getAllArticles(new Preference(ArticleListActivity.this).getToken(), "4");
        articleResponsCall.enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {
                ArticleResponse articleResponse = response.body();
                rvArticleList.setAdapter(new ArticleListAdapter(articleResponse.getData().getArticles()));
            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {

            }
        });
    }
}
