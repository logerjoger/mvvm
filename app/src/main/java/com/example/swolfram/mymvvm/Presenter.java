package com.example.swolfram.mymvvm;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by s.wolfram on 21.02.18.
 */

public class Presenter implements LifecycleObserver{
    public void onClickView(View view, MainViewModel viewModel) {
        viewModel.setText("neuer Text");
    }

    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int oldPadding, int newPadding) {
        if (oldPadding != newPadding) {
            view.setPadding(newPadding,
                    view.getPaddingTop(),
                    view.getPaddingRight(),
                    view.getPaddingBottom());
        }
    }

    @BindingAdapter({"bind:imageUrl", "bind:error"})
    public static void loadImage(ImageView view, String url, Drawable error) {
     //   Picasso.with(view.getContext()).load(url).error(error).into(view);
    }



    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }
}