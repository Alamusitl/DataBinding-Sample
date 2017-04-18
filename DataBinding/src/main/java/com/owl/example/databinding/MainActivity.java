package com.owl.example.databinding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Alamusi on 2017/4/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSimpleClick(View view) {
        startActivity(new Intent(this, SimpleActivity.class));
    }

    public void onListClick(View view) {
        startActivity(new Intent(this, ListActivity.class));
    }

    public void onTwoWayBindingClick(View view) {
        startActivity(new Intent(this, TwoWayBindingActivity.class));
    }

    public void onLambdaClick(View view) {
        startActivity(new Intent(this, LambdaActivity.class));
    }

    public void onExpressionClick(View view) {
        startActivity(new Intent(this, ExpressionActivity.class));
    }

    public void onAnimationClick(View view) {
        startActivity(new Intent(this, AnimationActivity.class));
    }
}
