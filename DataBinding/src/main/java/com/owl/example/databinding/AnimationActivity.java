package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import com.owl.example.databinding.databinding.ActivityAnimationBinding;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class AnimationActivity extends AppCompatActivity {

    private ActivityAnimationBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        mBinding.addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                ViewGroup viewGroup = (ViewGroup) binding.getRoot();
                TransitionManager.beginDelayedTransition(viewGroup);
                return true;
            }
        });
        mBinding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onCheckedChanged(View buttonView, boolean isCheck) {
            mBinding.setShowImage(isCheck);
        }
    }
}
