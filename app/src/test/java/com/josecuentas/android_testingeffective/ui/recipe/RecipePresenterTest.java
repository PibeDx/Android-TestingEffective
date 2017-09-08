package com.josecuentas.android_testingeffective.ui.recipe;

import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.data.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by jcuentas on 8/09/17.
 */
public class RecipePresenterTest {

    private RecipeStore store;
    private Favorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;

    @Before
    public void setup() {
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(Favorites.class);

        view = Mockito.mock(RecipeContract.View.class);
        presenter = new RecipePresenter(store, view, favorites);
    }

    @Test
    public void recipeNotFound() {
        when(store.getRecipe(anyString())).thenReturn(null);
        presenter.loadRecipe("no_such_recipe");
        verify(view, times(1)).showRecipeNotFoundError();
    }

    @Test(expected = IllegalStateException.class)
    public void toggleWithoutLoad() {
        presenter.toggleFavorite();
    }

    @Test
    public void loadWaterAndFavorite() {
        InputStream stream = RecipePresenterTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        when(store.getRecipe(anyString())).thenReturn(recipe);
        when(favorites.toogle(anyString())).thenReturn(true);

        presenter.loadRecipe("water");  //time1
        presenter.toggleFavorite();     //time2

        ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);
        verify(view, times(2)).setFavorite(captor.capture());
        assertFalse(captor.getAllValues().get(0));
        assertTrue(captor.getAllValues().get(1));
    }

}