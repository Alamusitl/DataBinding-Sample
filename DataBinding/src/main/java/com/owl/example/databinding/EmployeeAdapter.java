package com.owl.example.databinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class EmployeeAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    private static final int ITEM_VIEW_TYPE_ON = 1;
    private static final int ITEM_VIEW_TYPE_OFF = 2;

    private final LayoutInflater mLayoutInflater;
    private OnItemClickListener mListener;
    private List<Employee> mEmployeeList;
    private Random mRandom = new Random(System.currentTimeMillis());

    public EmployeeAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mEmployeeList = new ArrayList<>();
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding;
        if (viewType == ITEM_VIEW_TYPE_ON) {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee, parent, false);
        } else {
            binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off, parent, false);
        }

        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        final Employee employee = mEmployeeList.get(position);
        holder.getBinding().setVariable(com.owl.example.databinding.BR.item, employee);
        holder.getBinding().executePendingBindings();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onEmployeeClick(employee);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        final Employee employee = mEmployeeList.get(position);
        if (employee.isFired()) {
            return ITEM_VIEW_TYPE_OFF;
        } else {
            return ITEM_VIEW_TYPE_ON;
        }
    }

    @Override
    public int getItemCount() {
        return mEmployeeList.size();
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public void addAll(List<Employee> list) {
        mEmployeeList.addAll(list);
    }

    public void add(Employee employee) {
        int position = mRandom.nextInt(mEmployeeList.size() + 1);
        mEmployeeList.add(position, employee);
        notifyItemInserted(position);
    }

    public void remove() {
        if (mEmployeeList.size() == 0) {
            return;
        }
        int position = mRandom.nextInt(mEmployeeList.size());
        mEmployeeList.remove(position);
        notifyItemRemoved(position);
    }

    public interface OnItemClickListener {
        void onEmployeeClick(Employee employee);
    }
}