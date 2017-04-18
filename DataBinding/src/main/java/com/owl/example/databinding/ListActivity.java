package com.owl.example.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.owl.example.databinding.databinding.ActivityListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class ListActivity extends AppCompatActivity {

    private ActivityListBinding mBinding;

    private EmployeeAdapter mEmployeeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list);

        mBinding.setPresenter(new Presenter());

        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmployeeAdapter = new EmployeeAdapter(this);
        mBinding.recyclerView.setAdapter(mEmployeeAdapter);
        mEmployeeAdapter.setListener(new EmployeeAdapter.OnItemClickListener() {
            @Override
            public void onEmployeeClick(Employee employee) {
                Toast.makeText(ListActivity.this, employee.getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });
        List<Employee> demoList = new ArrayList<>();
        demoList.add(new Employee("A", "AA", false));
        demoList.add(new Employee("B", "BB", false));
        demoList.add(new Employee("C", "CC", true));
        demoList.add(new Employee("D", "DD", false));
        mEmployeeAdapter.addAll(demoList);
    }

    public class Presenter {
        public void onClickAddItem(View view) {
            mEmployeeAdapter.add(new Employee("E", "EE", false));
        }

        public void onClickRemoveItem(View view) {
            mEmployeeAdapter.remove();
        }
    }
}
