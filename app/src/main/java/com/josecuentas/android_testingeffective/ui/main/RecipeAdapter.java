package com.josecuentas.android_testingeffective.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josecuentas.android_testingeffective.R;
import com.josecuentas.android_testingeffective.data.local.RecipeStore;
import com.josecuentas.android_testingeffective.data.model.Recipe;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {
        this.store = store;
    }

    @Override public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override public void onBindViewHolder(RecipeViewHolder holder, int position) {
        final Recipe recipe = store.recipes.get(position);
        holder.textView.setText(recipe.title);
    }

    @Override public int getItemCount() {
        return store.recipes.size();
    }
}
