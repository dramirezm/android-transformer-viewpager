package com.beltranfebrer.transformerviewpagerapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.lzyzsd.randomcolor.RandomColor;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;
    private int currentColor, leftColor, rightColor;
    private RandomColor randomColor = new RandomColor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateColors(randomColor.randomColor());

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPagerAdapter.setColorSet(currentColor, leftColor, rightColor);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1);
        mPager.setPageTransformer(true, new DepthPageTransformer());

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int currentPos;
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (currentPos == 0) {
                        updateColors(leftColor);
                        mPagerAdapter.setColorSet(currentColor, leftColor, rightColor);
                        mPager.setAdapter(mPagerAdapter);
                        mPager.setCurrentItem(1, false);
                    } else if (currentPos == 2)  {
                        updateColors(rightColor);
                        mPagerAdapter.setColorSet(currentColor, leftColor, rightColor);
                        mPager.setAdapter(mPagerAdapter);
                        mPager.setCurrentItem(1, false);
                    }
                }
            }
        });

    }

    private void updateColors(int newColor) {
        leftColor = randomColor.randomColor();
        rightColor = randomColor.randomColor();
        currentColor = newColor;
    }
}
