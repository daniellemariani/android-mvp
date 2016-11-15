package com.dmariani.mvp.di;

import com.dmariani.mvp.ui.activity.AboutActivity;
import com.dmariani.mvp.ui.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Dagger component which manages dependency injection over the
 * given modules
 *
 * @author danielle.mariani
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MainActivity activity);

    void inject(AboutActivity activity);
}
