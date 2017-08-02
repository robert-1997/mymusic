package com.example.huangdouya.mymusicapplication.customview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.huangdouya.mymusicapplication.R;
import com.example.huangdouya.mymusicapplication.databinding.FragmentMsgDialogBinding;


/**
 * Created by huangdouya on 2017/8/2.
 */

public class MsgDialog extends DialogFragment {


    private FragmentMsgDialogBinding binding;
    private ClickEvent clickEvent;
    private String tag;
    private String title;
    private String content;
    private String cancel;
    private String ok;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//宽度全屏的关键
        getDialog().getWindow().setLayout((int) (metrics.widthPixels * 0.75), ViewGroup.LayoutParams.WRAP_CONTENT);
        getDialog().getWindow().setGravity(Gravity.CENTER);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_msg_dialog, container, false);
        return binding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        clickEvent = (ClickEvent) context;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tag = getTag();
        if(!TextUtils.isEmpty(title)){
            binding.tvTitle.setText(title);
        }
        if(!TextUtils.isEmpty(content)){
            binding.tvContent.setText(content);
        }
        if(!TextUtils.isEmpty(cancel)){
            binding.tvCancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(ok)){
            binding.tvOk.setText(ok);
        }
        binding.tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEvent.clickCancel(tag);
                dismiss();
            }
        });
        binding.tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickEvent.clickOk(tag);
                dismiss();
            }
        });
    }

    public interface ClickEvent {
        void clickCancel(String tag);

        void clickOk(String tag);
    }


}
