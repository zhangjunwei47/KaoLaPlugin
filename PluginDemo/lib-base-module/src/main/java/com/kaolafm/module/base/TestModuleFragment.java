package com.kaolafm.module.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kaolafm.module.util.TestUtilModule;

import me.yokeyword.fragmentation.SupportFragment;

public class TestModuleFragment extends SupportFragment {

    ImageView imageView;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_module, container, false);
        imageView = view.findViewById(R.id.testImageView);
        textView = view.findViewById(R.id.testView);
        TestUtilModule.setStyle(textView);
        textView.setTextColor(getResources().getColor(R.color.kaolared));
        int padding = TestUtilModule.getGlobalPaddingLeft(2);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setOnClickListener(v -> Toast.makeText(TestModuleFragment.this.getContext(), "我是点击事件", Toast.LENGTH_LONG).show());
    }

}
