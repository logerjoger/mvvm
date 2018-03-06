package com.example.swolfram.mymvvm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.SharedElementCallback;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by s.wolfram on 05.03.18.
 */

public class FragmentA extends Fragment {
    static final String TRANSITION_NAME_SOURCE = "transition_source_name";
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        prepareFragment();
        View view = inflater.inflate(R.layout.fragment_a, container, false);
         iv = view.findViewById(R.id.source_image);
        ((Button)view.findViewById(R.id.source_button)).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                 fragmentManager
                         .beginTransaction()
                         .replace(R.id.rootLayout, new FragmentB(), FragmentB.class.getSimpleName())
                         .commit();
             }
         });
         iv.setTransitionName(TRANSITION_NAME_SOURCE);
        return view;
    }

    private void prepareFragment() {
        setExitTransition(TransitionInflater.from(getContext()).inflateTransition(R.transition.grid_exit_transition));

        setExitSharedElementCallback(new SharedElementCallback() {
            @Override
            public void onMapSharedElements(List<String> names, Map<String, View> sharedElements) {
                sharedElements.put(names.get(0), iv);
            }
        });
    }
}
