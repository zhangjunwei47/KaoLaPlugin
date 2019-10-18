package com.didi.virtualapk.demo.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.didi.virtualapk.demo.R;
import com.kaolafm.base.BaseFragment;
import com.kaolafm.test.TestFragment;



public class LauncherFragment extends BaseFragment {
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
        imageView = view.findViewById(R.id.iv1x);
        imageView.setOnClickListener(v -> extraTransaction().start(new TestFragment()));
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
