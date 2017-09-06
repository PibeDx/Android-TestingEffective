package com.josecuentas.android_testingeffective.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;
import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.SharedPreferencesFavorites;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.data.model.Recipe;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    static {
        //Permite aplicar tinta en vectores
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        SharedPreferencesFavorites favorites = new SharedPreferencesFavorites(this);
        boolean favorite = favorites.get(recipe.id);
        titleView.setText(recipe.title);
        titleView.setSelected(false);
        descriptionView.setText(recipe.description);
    }
}
