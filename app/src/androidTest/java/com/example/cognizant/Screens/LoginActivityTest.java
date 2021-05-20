package com.example.cognizant.Screens;

import android.app.Activity;
import android.app.Instrumentation;
import android.util.Log;
import android.view.View;

import androidx.test.rule.ActivityTestRule;

import com.example.cognizant.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;



import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule  = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity mActivity = null;
    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(ListViewActivity.class.getName(), null, false);


    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        View view = mActivity.findViewById(R.id.username);
        View view2 = mActivity.findViewById(R.id.password);
        View view3 = mActivity.findViewById(R.id.loginBtn);
        assertNotNull(view);
        assertNotNull(view2);
        assertNotNull(view3);
    }

    /**
     * If user clicks on button, and they are authenticated the new list view page should be opened
     *
     */
//    @Test
//    public void testLaunchOfSecondActivityOnButtonClick() {
//        assertNotNull(mActivity.findViewById(R.id.loginBtn));
//
//        onView(withId(R.id.loginBtn)).perform(click());
//
//        Activity listViewScreen = getInstrumentation().waitForMonitorWithTimeout(monitor, 5000);
//
//        assertNotNull(listViewScreen);
//
//
//    }


    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}