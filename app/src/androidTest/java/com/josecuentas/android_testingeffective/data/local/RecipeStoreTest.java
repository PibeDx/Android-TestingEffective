package com.josecuentas.android_testingeffective.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.josecuentas.android_testingeffective.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jcuentas on 6/09/17.
 */
public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());
    }

    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        Recipe recipe = store.getRecipe("cholodate_pudding");
        assertNotNull(recipe);
        assertEquals("cholodate_pudding", recipe.id);
        assertEquals("Cholate Pudding", recipe.title);
    }

}