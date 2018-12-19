package com.example.marwe497.projectshowoff;

import android.app.Activity;
import android.graphics.Color;
import android.os.IBinder;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.Root;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.view.WindowManager;

import com.example.marwe497.passwordstrengthmeter.PasswordStrengthMeter;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);



    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testPasswordConditions(){
        //Too short
        Espresso.onView(withId(10)).perform(typeText("asdgfsa"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(0)).check(matches(withText("Too short")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("Password not OK!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        Espresso.onView(withId(0)).check((ViewAssertion) hasTextColor(Color.GRAY));


        //Weak

        Espresso.onView(withId(10)).perform(typeText("aaaaaaaa"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(0)).check(matches(withText("Weak")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("Password not OK!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        Espresso.onView(withId(0)).check((ViewAssertion) hasTextColor(Color.RED));

        //Fair

        Espresso.onView(withId(10)).perform(typeText("aaaaaaaaaa"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(0)).check(matches(withText("Fair")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("Password OK!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        Espresso.onView(withId(0)).check((ViewAssertion) hasTextColor(Color.parseColor("#FF6501")));

        //Good
        Espresso.onView(withId(10)).perform(typeText("zzzzzzzzzzzzz"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(0)).check(matches(withText("Good")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("Password OK!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        Espresso.onView(withId(0)).check((ViewAssertion) hasTextColor(Color.BLUE));

        //Strong
        Espresso.onView(withId(10)).perform(typeText("zzzzzzzzzzzzzzzzzzzzz"));
        Espresso.closeSoftKeyboard();
        Espresso.onView(withId(0)).check(matches(withText("Strong")));
        Espresso.onView(withId(R.id.button)).perform(click());
        Espresso.onView(withText("Password OK!")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));
        Espresso.onView(withId(0)).check((ViewAssertion) hasTextColor(Color.GREEN));

    }

    @After
    public void tearDown() throws Exception {
    }
}

class ToastMatcher extends TypeSafeMatcher<Root> {

    @Override
    public void describeTo(Description description) {
        description.appendText("is toast");
    }

    @Override
    public boolean matchesSafely(Root root) {
        int type = root.getWindowLayoutParams().get().type;
        if ((type == WindowManager.LayoutParams.TYPE_TOAST)) {
            IBinder windowToken = root.getDecorView().getWindowToken();
            IBinder appToken = root.getDecorView().getApplicationWindowToken();
            if (windowToken == appToken) {
                return true;
            }
        }
        return false;
    }
}