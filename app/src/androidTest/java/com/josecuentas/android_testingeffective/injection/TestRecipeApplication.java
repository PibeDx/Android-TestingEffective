package com.josecuentas.android_testingeffective.injection;

import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.InMemonyFavorites;

/**
 * Created by jcuentas on 6/09/17.
 */

public class TestRecipeApplication extends RecipeApplication {

    private final Favorites favorites = new InMemonyFavorites();

    @Override public Favorites getFavorites() {
        return favorites;
    }
}
