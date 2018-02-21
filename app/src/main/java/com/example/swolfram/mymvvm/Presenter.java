package com.example.swolfram.mymvvm;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class Presenter {
    public void onClickView(View view, MainViewModel viewModel) {
        ((TextView)view).setText("Hallo!");
    }
}