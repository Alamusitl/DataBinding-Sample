package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.owl.example.databinding.databinding.ActivityExpressionBinding;

import java.util.Random;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class ExpressionActivity extends AppCompatActivity {

    private ActivityExpressionBinding mBinding;

    private Random mRandom = new Random(System.currentTimeMillis());


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Employee employee = new Employee("Owl", "A");
        employee.setFired(mRandom.nextBoolean());
        employee.setAvatar("https://avatars0.githubusercontent.com/u/10684822?v=3&u=b547b846a4d9e28c8403d59cdaba82aa550fe937&s=400");

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_expression);
        mBinding.setEmployee(employee);
    }
}
