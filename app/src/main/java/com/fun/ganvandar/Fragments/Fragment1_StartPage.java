package com.fun.ganvandar.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fun.ganvandar.R;

public class Fragment1_StartPage extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1__start_page, container, false);
    }


    @Override
    public void onViewCreated(View view,Bundle bundle){

    }
}
