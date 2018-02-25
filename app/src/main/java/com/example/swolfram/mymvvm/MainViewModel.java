package com.example.swolfram.mymvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class MainViewModel extends BaseObservable{

    public String text;

    public boolean isAdult = true;

    MainViewModel(String text) {
        this.text = text;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
