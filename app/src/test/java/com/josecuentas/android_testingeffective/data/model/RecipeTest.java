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
        InputStream stream = RecipeTest.class.getResourceAsStream("/recupes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);
        assertNotNull(recipe);
    }

}