package com.example.swolfram.mymvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.TextView;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class MainViewModel {

    public ObservableField<String> text = new ObservableField<>();

    public boolean isAdult = true;

    MainViewModel(String text) {
        this.text.set(text);
    }

    public ObservableField<String> getText() {
        return text;
    }

    public void setText(String text) {
        this.text.set(text);
    }

}
