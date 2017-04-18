package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.owl.example.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Employee mEmployee = new Employee("XiaoMing", "XiaoHua");
    private Presenter mPresenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        binding.firstName.setText(mEmployee.firstName);
//        binding.lastName.setText(mEmployee.lastName);

        mBinding.setEmployee(mEmployee);
        mBinding.setPresenter(mPresenter);
    }

    public class Presenter {

        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            mEmployee.setFirstName(text.toString());
            mBinding.setEmployee(mEmployee);
        }

        public void onClick(View view) {
            Toast.makeText(MainActivity.this, "Oh, Yeh!", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(MainActivity.this, employee.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }
}
