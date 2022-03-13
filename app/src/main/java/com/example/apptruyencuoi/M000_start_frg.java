package com.example.apptruyencuoi;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class M000_start_frg extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m000_start_frg, container, false);

        initViews();

        return view;
    }

    private void initViews() {

        new Handler().postDelayed(this::gotoM001Screen, 2000);
    }

    private void gotoM001Screen() {
        ((MainActivity)getContext()).gotoM001Screen();
    }
}
