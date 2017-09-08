package com.josecuentas.android_testingeffective.ui.recipe;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.test.RecipeRobot;
import org.junit.Rule;
import org.junit.Test;
/**
 * Created by jcuentas on 6/09/17.
 */
public class RecipeActivityTest {

    public static final String CARROTS_ID = "creamed_carrots";
    public static final String CARROTS_NAME = "Creamed Carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule = new ActivityTestRule<RecipeActivity>(RecipeActivity.class, true, false) {
        @Override protected void beforeActivityLaunched() {
            //Limpiamos los datos del preference para poder ejecutar
            //el test "clickToFavorite" sin problemas
            //SharedPreferencesFavorites favorites = new SharedPreferencesFavorites(InstrumentationRegistry.getTargetContext());
            //favorites.clear();
            super.beforeActivityLaunched();
        }
    };

    @Test
    public void recipeNotFound() {
        new RecipeRobot()
                .launch(activityRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }

    @Test
    public void clickToFavorite() {
        new RecipeRobot()
                .launch(activityRule, CARROTS_ID)
                .title(CARROTS_NAME)
                .noFavorite()
                .clickFavorite()
                .isFavorite();
    }

    @Test
    public void alreadyFavorite() {
        new RecipeRobot()
                .setFavorite(CARROTS_ID)
                .launch(activityRule, CARROTS_ID)
                .isFavorite();
    }

    private void launchRecipe(String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        activityRule.launchActivity(intent);
    }

}