package com.didi.virtualapk.demo.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.didi.virtualapk.demo.R;

import me.yokeyword.fragmentation.SupportFragment;

public class LauncherFragment extends SupportFragment {

    public static LauncherFragment getInstance() {
        LauncherFragment launcherFragment = new LauncherFragment();
        return launcherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_launcher, container, false);
        return view;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}