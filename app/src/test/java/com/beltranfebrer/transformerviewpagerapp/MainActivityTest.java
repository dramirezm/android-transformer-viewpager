package com.beltranfebrer.transformerviewpagerapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by miquel on 21.01.16.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    MainActivityPresenter presenter;
    MainActivityView view;
    ArgumentCaptor<Integer> colorCaptured;

    @Before
    public void setUp() throws Exception {
        view = mock(MainActivityView.class);
        presenter = new MainActivityPresenter(view);
        colorCaptured = ArgumentCaptor.forClass(Integer.class);
    }

    @Test
    public void testDefault() throws Exception {
        verify(view).setColors(anyInt(), anyInt(), anyInt());
    }

    @Test
    public void testToTheLeft() throws Exception {
        verify(view).setColors(anyInt(), colorCaptured.capture(), anyInt());
        presenter.switchToPos(0);
        verify(view).setColors(eq(colorCaptured.getValue().intValue()), anyInt(), anyInt());
    }

    @Test
    public void testToTheRight() throws Exception {
        verify(view).setColors(anyInt(), anyInt(), colorCaptured.capture());
        presenter.switchToPos(2);
        verify(view).setColors(eq(colorCaptured.getValue().intValue()), anyInt(), anyInt());
    }
}
