package com.josecuentas.android_testingeffective.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public final TextView textView;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView;
    }
}
