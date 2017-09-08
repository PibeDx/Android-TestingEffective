package com.josecuentas.android_testingeffective.test;

import android.support.annotation.IdRes;
import static android.support.test.espresso.Espresso.*;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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

}
