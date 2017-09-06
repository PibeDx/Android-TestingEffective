package com.josecuentas.android_testingeffective.data.model;

import org.junit.Test;

import java.io.InputStream;
import static org.junit.Assert.*;
/**
 * Created by jcuentas on 6/09/17.
 */
public class RecipeTest {
    @Test
    public void water() {
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
        assertEquals("water", recipe.id);
        assertEquals("Water", recipe.title);
        assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);
    }

}