package com.josecuentas.android_testingeffective.test;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.josecuentas.android_testingeffective.injection.TestRecipeApplication;

/**
 * Created by jcuentas on 6/09/17.
 */

public class CustomTestRunner extends AndroidJUnitRunner {
    @Override public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}
