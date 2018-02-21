package com.example.swolfram.mymvvm;

import android.view.View;
import android.widget.TextView;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class MainViewModel {

    public MainViewModel(String text) {
        this.text = text;
    }

    public String text;


    public void onClickView(View view) {
        text = "Hallo";
    }

}
