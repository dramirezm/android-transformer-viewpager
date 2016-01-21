package com.beltranfebrer.transformerviewpagerapp;

import com.github.lzyzsd.randomcolor.RandomColor;

/**
 * Created by miquel on 21.01.16.
 */
public class MainActivityPresenter {
    private int currentColor, leftColor, rightColor;
    private RandomColor randomColor = new RandomColor();
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
        updateColors(randomColor.randomColor());
        view.setColors(currentColor, leftColor, rightColor);
    }

    private void updateColors(int newColor) {
        leftColor = randomColor.randomColor();
        rightColor = randomColor.randomColor();
        currentColor = newColor;
    }

    public void switchToPos(int currentPos) {
        switch (currentPos) {
            case 0:
                updateColors(leftColor);
                view.setColors(currentColor, leftColor, rightColor);
                break;
            case 2:
                updateColors(rightColor);
                view.setColors(currentColor, leftColor, rightColor);
                break;
        }
    }
}
