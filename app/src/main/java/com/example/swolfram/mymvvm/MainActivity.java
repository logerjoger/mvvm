package com.example.swolfram.mymvvm;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.swolfram.mymvvm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        ActivityMainBinding activityMainBinding1 = ActivityMainBinding.inflate(getLayoutInflater());
        activityMainBinding.setUser(new MainViewModel("Hallo du!"));
        activityMainBinding.setHandler(new Presenter());
//        activityMainBinding.setVariable(BR)
    }

}