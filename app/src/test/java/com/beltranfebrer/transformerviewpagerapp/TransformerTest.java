package com.beltranfebrer.transformerviewpagerapp;

import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by miquel on 21.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class TransformerTest {
    DepthPageTransformer transformer;
    View view;

    @Before
    public void setUp() throws Exception {
        transformer = new DepthPageTransformer();
        view = mock(View.class);
    }

    @Test
    public void testOutOfScreenLeft() throws Exception {
        transformer.transformPage(view, (float) -2.1);
        verify(view).setAlpha(0);
    }

    @Test
    public void testOutOfScreenRight() throws Exception {
        transformer.transformPage(view, (float) 2.1);
        verify(view).setAlpha(0);
    }

    @Test
    public void testHalfTransitionLeft() throws Exception {
        transformer.transformPage(view, (float) -0.5);
        verify(view).setAlpha(0.5f);
        verify(view).setScaleX(0.85f);
        verify(view).setScaleY(0.85f);
        verify(view).setTranslationX(anyFloat());
    }


    @Test
    public void testHalfTransitionRight() throws Exception {
        transformer.transformPage(view, (float) 0.5);
        verify(view).setAlpha(0.5f);
        verify(view).setScaleX(0.85f);
        verify(view).setScaleY(0.85f);
        verify(view).setTranslationX(anyFloat());
    }
}
