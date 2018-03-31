package com.rdevlab.tupresidentesoundboard.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rdevlab.tupresidentesoundboard.R;

import static com.rdevlab.tupresidentesoundboard.MainActivity.viewPager;

/**
 * A simple {@link Fragment} subclass.
 *
 * @author rms
 */
public class AllPresidentsFragment extends Fragment {

    private static final String TAG = "AllPresidentsFragment";

    public AllPresidentsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_all, container, false);

        Button mPenaNietoButton = rootView.findViewById(R.id.pena_nieto_button);

        mPenaNietoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1, true);
            }
        });

        return rootView;
    }
}
