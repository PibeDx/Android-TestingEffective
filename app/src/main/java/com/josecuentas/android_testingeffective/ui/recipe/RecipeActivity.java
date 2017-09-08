package com.josecuentas.android_testingeffective.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.TextView;
import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.data.local.Favorites;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.injection.RecipeApplication;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {

    public static final String KEY_ID = "id";

    static {
        //Permite aplicar tinta en vectores
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private TextView descriptionView;
    private TextView titleView;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Step1: Set up the UI
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        titleView = (TextView) findViewById(R.id.title);
        descriptionView = (TextView) findViewById(R.id.description);

        // Step 2: Load recipe from store
        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites = app.getFavorites();
        final RecipePresenter presenter = new RecipePresenter(store, this, favorites);
        presenter.loadRecipe(id);

        // Step 3: If recipe is null, show error. This is done in the presenter

        // Step 4: If recipe is not null, show recipe. This is done in the presenter

        // Step 5: When title is clicked, toggle favorites
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                presenter.toggleFavorite();
            }
        });
    }

    @Override public void showRecipeNotFoundError() {
        titleView.setVisibility(View.GONE);
        descriptionView.setText(R.string.recipe_not_found);
    }

    @Override public void setTitle(String title) {
        titleView.setText(title);
    }

    @Override public void setDescription(String description) {
        descriptionView.setText(description);
    }

    @Override public void setFavorite(boolean favorite) {
        titleView.setSelected(favorite);
    }
}
