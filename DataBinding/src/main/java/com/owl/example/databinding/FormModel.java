package com.owl.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class FormModel extends BaseObservable {

    private String mName;
    private String mPassword;

    public FormModel(String name, String password) {
        mName = name;
        mPassword = password;
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
        notifyPropertyChanged(BR.password);
    }
}
