package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.owl.example.databinding.databinding.ActivitySimpleBinding;

public class SimpleActivity extends AppCompatActivity {

    private ActivitySimpleBinding mBinding;
    private Employee mEmployee = new Employee("XiaoMing", "XiaoHua");
    private Presenter mPresenter = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_simple);

        mBinding.setEmployee(mEmployee);
        mBinding.setPresenter(mPresenter);
        mBinding.viewstub.getViewStub().inflate();
    }

    public class Presenter {

        public void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
            mEmployee.setFirstName(text.toString());
            mEmployee.setFired(!mEmployee.isFired());
        }

        public void onClick(View view) {
            Toast.makeText(SimpleActivity.this, "Oh, Yeh!", Toast.LENGTH_SHORT).show();
        }

        public void onClickListenerBinding(Employee employee) {
            Toast.makeText(SimpleActivity.this, employee.getLastName(), Toast.LENGTH_SHORT).show();
        }
    }
}
