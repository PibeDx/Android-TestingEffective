package com.josecuentas.android_testingeffective.test;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import com.josecuentas.android_testingeffective.R;

/**
 * Created by jcuentas on 8/09/17.
 */

public class RecipeRobot extends ScreemRobot<RecipeRobot> {

    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

}
