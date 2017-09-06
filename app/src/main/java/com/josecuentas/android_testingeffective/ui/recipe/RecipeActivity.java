package com.josecuentas.android_testingeffective.ui.recipe;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.josecuentas.android_testingeffective.R;

/**
 * Created by jcuentas on 6/09/17.
 */

public class RecipeActivity extends AppCompatActivity {

    public static final String KEY_ID = "id";

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }
}
