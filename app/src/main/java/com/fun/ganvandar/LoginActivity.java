package com.fun.ganvandar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fun.ganvandar.Article.ArticleListActivity;
import com.fun.ganvandar.Category.CategoryListActivity;
import com.fun.ganvandar.User.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText edLoginUsername, edtLoginPassword;

    Button btnSignIn, btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edLoginUsername = findViewById(R.id.edtLoginUsername);
        edtLoginPassword = findViewById(R.id.edtLoginPassword);

        btnSignIn = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUP);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IAPICall iApiCall = RetrofitFactory.getRetrofit().create(IAPICall.class);


                //UserLogin
                Call<UserResponse> call = iApiCall.login(edLoginUsername.getText().toString(),edtLoginPassword.getText().toString() );


                call.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                        UserResponse userResponse = response.body();
                        new Preference(LoginActivity.this).setToken(userResponse.getData().getToken());
                        //login start main activity
                        Intent intent = new Intent(LoginActivity.this, CategoryListActivity.class);
                        startActivity(intent);
                        finishAffinity();
                    }


                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Connection error", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
    }
}
