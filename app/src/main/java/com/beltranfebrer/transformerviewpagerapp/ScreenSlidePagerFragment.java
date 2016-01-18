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
    public static ScreenSlidePagerFragment newInstance(int index) {
        ScreenSlidePagerFragment f = new ScreenSlidePagerFragment();
        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);
        Bundle args = getArguments();
        int index = args.getInt("index", 0);
        TextView textView = (TextView) rootView.findViewById(R.id.fragment_text);
        ScrollView scrollView = (ScrollView) rootView.findViewById(R.id.content);
        switch (index) {
            case 0:
                textView.setText("Next left");
                scrollView.setBackgroundColor(Color.GREEN);
                break;
            case 1:
                textView.setText("Current");
                scrollView.setBackgroundColor(Color.YELLOW);
                break;
            case 2:
                textView.setText("Next right");
                scrollView.setBackgroundColor(Color.BLUE);
                break;
            default:
                textView.setText("Unknown");
        }
        return rootView;
    }

}
