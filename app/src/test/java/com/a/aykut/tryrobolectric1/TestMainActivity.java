package com.a.aykut.tryrobolectric1;


import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 21)
public class TestMainActivity {

  Activity activity;
  TextView textView;
  Button button;

  @Before
  public void setUp() {
    activity = Robolectric.setupActivity(MainActivity.class);
    textView = (TextView) activity.findViewById(R.id.textView);
    button = (Button) activity.findViewById(R.id.button);
  }

  @Test
  public void shouldMainActivityNotBeNull() throws Exception {
    Robolectric.buildActivity(MainActivity.class).create().pause().resume().get();
    assertTrue(Robolectric.buildActivity(MainActivity.class).create().get() != null);
    String hello = new MainActivity().getResources().getString(R.string.hello_world);
    assertEquals(hello, "Hello world!");


  }

  @Test
  public void buttonClickChangeTextView() throws Exception {
    String text = textView.getText().toString();
    assertEquals(text, "Hello world!");
    button.performClick();
    text = textView.getText().toString();
    assertEquals(text, "tiklandi");

  }
}
