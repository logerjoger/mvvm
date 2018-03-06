package com.example.swolfram.mymvvm;

import com.example.swolfram.mymvvm.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.SharedElementCallback;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by s.wolfram on 05.03.18.
 */

public class FragmentB extends Fragment {

    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        prepareFragment();
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        iv = view.findViewById(R.id.dest_image);
        view.findViewById(R.id.dest_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.rootLayout, new FragmentA(), FragmentA.class.getSimpleName())
                        .commit();
            }
        });
        return view;
    }

    private void prepareFragment() {
        Transition transition =
                TransitionInflater.from(getContext())
                        .inflateTransition(R.transition.image_shared_element_transition);
        setSharedElementEnterTransition(transition);

        setEnterSharedElementCallback(
                new SharedElementCallback() {
                    @Override
                    public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                        sharedElements.put(names.get(0), iv);
                    }
                });
    }
}
