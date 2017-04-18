package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.owl.example.databinding.databinding.ActivityTwoWayBinding;

public class TwoWayBindingActivity extends AppCompatActivity {

    private ActivityTwoWayBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);
        FormModel model = new FormModel("Owl", "123456");
        model.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable observable, int i) {
                Toast.makeText(TwoWayBindingActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });
        mBinding.setModel(model);
    }
}
