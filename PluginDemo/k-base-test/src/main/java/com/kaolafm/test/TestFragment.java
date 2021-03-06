package com.kaolafm.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaolafm.module.base.TestModuleFragment;
import com.kaolafm.module.util.TestUtilModule;

import me.yokeyword.fragmentation.SupportFragment;

public class TestFragment extends SupportFragment {

    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondx, container, false);
        imageView = view.findViewById(R.id.testImageView);
        textView = view.findViewById(R.id.testView);
        textView.setTextColor(getResources().getColor(R.color.kaolared));
        int padding = TestUtilModule.getGlobalPaddingLeft(2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setOnClickListener(v -> {
            extraTransaction().start(new TestModuleFragment());
        });
    }

}
