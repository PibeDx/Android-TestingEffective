package com.josecuentas.android_testingeffective.data.local;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jcuentas on 6/09/17.
 */

public class SharedPreferencesFavorites {

    private final SharedPreferences pref;

    public SharedPreferencesFavorites(Context context) {
        pref = context.getSharedPreferences("favorite.xml", Context.MODE_PRIVATE);
    }

    public boolean get(String id) {
        return pref.getBoolean(id, false);
    }

    public void put(String id, boolean favorite) {
        SharedPreferences.Editor editor = pref.edit();
        if (favorite) {
            editor.putBoolean(id, true);
        } else {
            editor.remove(id);
        }
        editor.apply();
    }

    public boolean toogle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }

    public void clear() {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

}
