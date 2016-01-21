package com.beltranfebrer.transformerviewpagerapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by miquel on 18.01.16.
 */
public class ScreenSlidePagerFragment extends Fragment {

    /**
     * Create a new instance of DetailsFragment, initialized to
     * show the text at 'index'.
     */
    public static ScreenSlidePagerFragment newInstance(int color) {
        ScreenSlidePagerFragment f = new ScreenSlidePagerFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("color", color);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        Bundle args = getArguments();
        int color = args.getInt("color", 0);
        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.content);
        scrollView.setBackgroundColor(color);
        return rootView;
    }

}
