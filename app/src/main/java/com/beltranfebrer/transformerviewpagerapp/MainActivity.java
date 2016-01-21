package com.beltranfebrer.transformerviewpagerapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.lzyzsd.randomcolor.RandomColor;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private MainActivityPresenter presenter;
    private ViewPager mPager;
    private ScreenSlidePagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        presenter = new MainActivityPresenter(this);
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
                    presenter.switchToPos(currentPos);
                }
            }
        });
    }

    @Override
    public void setColors(int currentColor, int leftColor, int rightColor) {
        mPagerAdapter.setColorSet(currentColor, leftColor, rightColor);
        mPager.setAdapter(mPagerAdapter);
        mPager.setCurrentItem(1, false);
    }
}
