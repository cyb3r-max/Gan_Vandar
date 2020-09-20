package com.fun.ganvandar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.fun.ganvandar.User.UserResponse;

import retrofit2.Call;

public class SignUpActivity extends AppCompatActivity {

    EditText edtName, edtUsername, edtEmail, edtPassword;

    Button btnSignUp;
    String[] UserType;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        edtName = findViewById(R.id.edtName);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        UserType = getResources().getStringArray(R.array.UserType);
        btnSignUp = findViewById(R.id.btnSignUP);
        spinner = findViewById(R.id.spr_UserType);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_view,R.id.tv_spr,UserType);
        spinner.setAdapter(adapter);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IAPICall iApiCall = RetrofitFactory.getRetrofit().create(IAPICall.class);

                Call<UserResponse> call = iApiCall.login(edtUsername.getText().toString(), edtPassword.getText().toString());
            }
        });


    }
}
