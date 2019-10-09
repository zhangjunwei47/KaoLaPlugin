package com.kaolafm.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import me.yokeyword.fragmentation.SupportFragment;

public abstract class BaseFragment extends SupportFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        //如果通过布局id找不到view，就尝试直接获取view。
        view = inflater.inflate(getLayoutId(), container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    protected abstract int getLayoutId();
}
