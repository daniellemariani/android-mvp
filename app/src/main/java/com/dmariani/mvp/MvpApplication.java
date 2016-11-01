package com.dmariani.mvp;

import android.app.Application;

import com.dmariani.mvp.di.ApplicationComponent;
import com.dmariani.mvp.di.DaggerApplicationComponent;

/**
 * Custom application class to handle global states and attributes.
 *
 * @author danielle.mariani
 */
public class MvpApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder().build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}
