package com.didi.virtualapk.demo.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.didi.virtualapk.demo.R;
import com.kaolafm.base.BaseFragment;

import butterknife.BindView;


public class LauncherFragment extends BaseFragment {
    @BindView(R.id.iv1x)
    ImageView imageView;

    public static LauncherFragment getInstance() {
        LauncherFragment launcherFragment = new LauncherFragment();
        return launcherFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setOnClickListener(v -> extraTransaction().start(new SecondFragment()));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_launcher;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
