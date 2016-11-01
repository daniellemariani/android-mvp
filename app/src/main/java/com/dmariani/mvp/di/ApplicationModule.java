package com.dmariani.mvp.di;

import com.dmariani.mvp.manager.AboutManager;
import com.dmariani.mvp.manager.AboutManagerImpl;
import com.dmariani.mvp.presenter.AboutPresenter;
import com.dmariani.mvp.presenter.AboutPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * It provides singletons injected through Dagger
 * @author danielle.mariani
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public AboutManager provideAboutManager() {
        return new AboutManagerImpl();
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter(AboutPresenterImpl presenter) {
        return presenter;
    }
}
