package com.josecuentas.android_testingeffective.test;

import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by jcuentas on 8/09/17.
 */

public abstract class ScreemRobot<T extends ScreemRobot> {

    public T checkIsHidden(@IdRes int... viewIds) {
        for (int viewId : viewIds) {
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())));
        }
        return (T) this;
    }

    public T checkViewHasText(@IdRes int viewId, @StringRes int stringId) {
        onView(withId(viewId))
                .check(matches(withText(stringId)));
        return (T) this;
    }

    public T checkViewHasText(@IdRes int viewId, String text) {
        onView(withId(viewId))
                .check(matches(withText(text)));
        return (T) this;
    }

    public T checkIsSelected(@IdRes int viewId) {
        onView(withId(viewId))
                .check(matches(isSelected()));
        return (T) this;
    }

    public T checkNoSelected(@IdRes int viewId) {
        onView(withId(viewId))
                .check(matches(not(isSelected())));
        return (T) this;
    }

    public T actionClick(@IdRes int viewId) {
        onView(withId(viewId))
                .perform(click());
        return (T) this;
    }

}
