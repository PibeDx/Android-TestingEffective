package com.josecuentas.android_testingeffective.ui.recipe;

/**
 * Created by jcuentas on 8/09/17.
 */

public interface RecipeContract {

    interface View {
        void showRecipeNotFoundError();
        void setTitle(String title);
        void setDescription(String description);
        void setFavorite(boolean favorite);
    }

    interface Listener {
        void toggleFavorite();
    }

}
