package com.kaolafm.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.kaolafm.base.BaseFragment;

import butterknife.BindView;

public class TestFragment extends BaseFragment {

    @BindView(R2.id.testImageView)
    ImageView imageView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_secondx;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setOnClickListener(v -> Toast.makeText(TestFragment.this.getContext(), "我是点击事件", Toast.LENGTH_LONG).show());
    }
}
