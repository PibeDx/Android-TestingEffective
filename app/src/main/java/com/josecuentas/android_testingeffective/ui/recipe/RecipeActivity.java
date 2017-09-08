package com.josecuentas.android_testingeffective.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;

import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.SharedPreferencesFavorites;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.data.model.Recipe;
import com.josecuentas.android_testingeffective.injection.RecipeApplication;

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
        // Step1: Set up the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);

        // Step 2: Load recipe from store
        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        // Step 3: If recipe is null, show error
        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        // Step 4: If recipe is not null, show recipe
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites = app.getFavorites();
        boolean favorite = favorites.get(recipe.id);

        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        descriptionView.setText(recipe.description);

        // Step 5: When title is clicked, toggle favorites
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                boolean result = favorites.toogle(recipe.id);
                titleView.setSelected(result);
            }
        });
    }
}
