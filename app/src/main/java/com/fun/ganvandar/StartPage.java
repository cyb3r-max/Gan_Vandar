package com.fun.ganvandar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fun.ganvandar.Category.CategoryListActivity;
import com.fun.ganvandar.Fragments.Fragment1_StartPage;
import com.fun.ganvandar.Fragments.Fragment2_StartPage;
import com.fun.ganvandar.Fragments.ViewPagerAdapter;

public class StartPage extends AppCompatActivity {

    Button btnSignIn, btnSignUp;
    ViewPager viewPager;
    Preference preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);


        preferences = new Preference(this);



        if((preferences.islogin())){
            startActivity(new Intent(StartPage.this, CategoryListActivity.class));
            finishAffinity();
        }else {

            viewPager = findViewById(R.id.viewpager);
            btnSignIn = findViewById(R.id.btnSignIn);
            btnSignUp = findViewById(R.id.btnSignUp);

            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
            viewPagerAdapter.addFragment(new Fragment1_StartPage());
            viewPagerAdapter.addFragment(new Fragment2_StartPage());
            viewPager.setAdapter(viewPagerAdapter);

            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(StartPage.this, LoginActivity.class));
                    finish();
                }
            });
            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(StartPage.this, SignUpActivity.class));
                }
            });
        }
    }
}
