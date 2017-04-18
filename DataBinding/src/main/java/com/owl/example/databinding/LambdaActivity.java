package com.owl.example.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.owl.example.databinding.databinding.ActivityLambdaBinding;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class LambdaActivity extends AppCompatActivity {

    private ActivityLambdaBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_lambda);

        mBinding.setEmployee(new Employee("Owl", "imagine"));
        mBinding.setPresenter(new Presenter());
    }


    public class Presenter {
        public void onEmployeeClick(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onEmployeeClick", Toast.LENGTH_SHORT).show();
        }

        public void onEmployeeLongClick(Context context, Employee employee) {
            Toast.makeText(LambdaActivity.this, "onEmployeeLongClick", Toast.LENGTH_SHORT).show();
        }

        public void onFocusChanged(Employee employee) {
            Toast.makeText(LambdaActivity.this, "onFocusChanged", Toast.LENGTH_SHORT).show();
        }
    }
}
