package com.example.swolfram.mymvvm;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class MainViewModel {

    public ObservableField<String> text = new ObservableField<>();
    public String url = "http://www.google.de";

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
