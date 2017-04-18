package com.owl.example.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayMap;
import android.databinding.ObservableBoolean;

/**
 * Created by Alamusi on 2017/4/17.
 */

public class Employee extends BaseObservable {

    private String mFirstName;

    private String mLastName;

    private String mAvatar;
    private ObservableBoolean mIsFired = new ObservableBoolean();
    private ObservableArrayMap<String, String> mUser = new ObservableArrayMap<>();

    public Employee(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
        mIsFired.set(false);
        mUser.put("hello", "world");
        mUser.put("hi", "world");
        mUser.put("hei", "world");
    }

    public Employee(String firstName, String lastName, boolean isFired) {
        mFirstName = firstName;
        mLastName = lastName;
        mIsFired.set(isFired);
    }

    public ObservableArrayMap<String, String> getUser() {
        return mUser;
    }

    public void setUser(ObservableArrayMap<String, String> user) {
        mUser = user;
    }

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
        notifyPropertyChanged(com.owl.example.databinding.BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
        notifyPropertyChanged(com.owl.example.databinding.BR.lastName);
    }

    @Bindable
    public boolean isFired() {
        return mIsFired.get();
    }

    public void setFired(boolean fired) {
        mIsFired.set(fired);
        notifyPropertyChanged(com.owl.example.databinding.BR.fired);
    }

    @Bindable
    public String getAvatar() {
        return mAvatar;
    }

    public void setAvatar(String avatar) {
        mAvatar = avatar;
        notifyPropertyChanged(BR.avatar);
    }
}
