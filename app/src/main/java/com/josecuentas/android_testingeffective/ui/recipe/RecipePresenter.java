package com.josecuentas.android_testingeffective.ui.recipe;

import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.data.model.Recipe;

/**
 * Created by jcuentas on 8/09/17.
 */

public class RecipePresenter implements RecipeContract.Listener {
    private final RecipeStore store;
    private final RecipeContract.View view;
    private final Favorites favorites;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);
            view.setFavorite(favorites.get(id));
        }
    }

    @Override public void toggleFavorite() {
        boolean result = favorites.toogle(recipe.id);
        view.setFavorite(result);
    }
}
