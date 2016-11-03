package com.dmariani.mvp.utils;

import android.util.Log;

/**
 * Custom Native Log
 *
 * @author danielle.mariani
 */

public class NLog {

    private static final String TAG = "dmariani-mvp";

    public static void i(String message) {
        Log.i(TAG, message);
    }

    public static void e(String message) {
        Log.e(TAG, message);
    }

    public static void e(Throwable t) {
        Log.e(TAG, "Exception: " + t.getMessage());
    }

    public static void e(String message, Throwable t) {
        Log.e(TAG, message, t);
    }

    public static void success() {
        i("Success!");
    }

    public static void result(String message) {
        i("Result: " + message);
    }

    public static void failed() {
        e("Failed!");
    }
}
