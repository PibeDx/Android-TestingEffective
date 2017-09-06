package com.josecuentas.android_testingeffective.data.local;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jcuentas on 6/09/17.
 */

public class InMemonyFavorites implements Favorites {

    private final Map<String, Boolean> map = new HashMap<>();

    @Override public boolean get(String id) {
        Boolean value = map.get(id);
        return value == null ? false : value;
    }

    @Override public boolean toogle(String id) {
        Boolean value = get(id);
        map.put(id, !value);
        return !value;
    }

    public void put(String id, boolean value) {
        map.put(id, value);
    }
}
