package com.josecuentas.android_testingeffective.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.data.local.InMemonyFavorites;
import com.josecuentas.android_testingeffective.injection.TestRecipeApplication;
import com.josecuentas.android_testingeffective.ui.recipe.RecipeActivity;

/**
 * Created by jcuentas on 8/09/17.
 */

public class RecipeRobot extends ScreemRobot<RecipeRobot> {

    private final InMemonyFavorites favorites;

    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication) InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemonyFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launch(ActivityTestRule rule, String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

    public RecipeRobot setFavorite(String id) {
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorite() {
        return checkIsSelected(R.id.title);
    }

    public RecipeRobot title(String title) {
        return checkViewHasText(R.id.title, title);
    }

    public RecipeRobot noFavorite() {
        return checkNoSelected(R.id.title);
    }

    public RecipeRobot clickFavorite() {
        return actionClick(R.id.title);
    }
}
