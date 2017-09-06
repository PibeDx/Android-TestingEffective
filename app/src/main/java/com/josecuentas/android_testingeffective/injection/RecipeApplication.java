package com.josecuentas.android_testingeffective.injection;

import android.app.Application;

import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.SharedPreferencesFavorites;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeApplication extends Application {

    private Favorites favorites = null;

    public Favorites getFavorites() {
        if (favorites == null) {
            favorites = new SharedPreferencesFavorites(this);
        }
        return favorites;
    }


}
