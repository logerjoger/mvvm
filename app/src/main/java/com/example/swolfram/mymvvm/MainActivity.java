package com.example.swolfram.mymvvm;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.swolfram.mymvvm.databinding.ActivityMainBinding;

/**
 *
 *
 * MainActivity setContentView for databinding and set model (User and Handler) in binding.
 * Then you have access to this model in view and in all view callbacks.
 *
 * Con: View (activity, fragment, etc.) must set all models.
 *
 * @see <a href="https://developer.android.com/topic/libraries/data-binding/index.html</a>
 */
public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel = new MainViewModel("Hallo du!");
    Presenter handler = new Presenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // TODO: 22.02.18 How use databing with dagger?

        activityMainBinding.setUser(mainViewModel);
        activityMainBinding.setHandler(handler);
        getLifecycle().addObserver(handler);

        startFragment();
        // TODO: 26.03.18 test todo
    }

    public void startFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.rootLayout, new FragmentA(), FragmentA.class.getSimpleName())
                .commit();
    }

}