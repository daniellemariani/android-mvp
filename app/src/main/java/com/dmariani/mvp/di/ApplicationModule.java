package com.dmariani.mvp.di;

import com.dmariani.mvp.api.ApiConstants;
import com.dmariani.mvp.api.GitHubApiClient;
import com.dmariani.mvp.manager.AboutManager;
import com.dmariani.mvp.manager.AboutManagerImpl;
import com.dmariani.mvp.manager.ProfileManager;
import com.dmariani.mvp.manager.ProfileManagerImpl;
import com.dmariani.mvp.presenter.AboutPresenter;
import com.dmariani.mvp.presenter.AboutPresenterImpl;
import com.dmariani.mvp.presenter.MainPresenter;
import com.dmariani.mvp.presenter.MainPresenterImpl;
import com.dmariani.mvp.utils.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * It provides singletons injected through Dagger
 *
 * @author danielle.mariani
 */

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public GitHubApiClient provideGitHubApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(GitHubApiClient.class);
    }

    @Provides
    @Singleton
    public RxBus provideRxBus() {
        return new RxBus();
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter(MainPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter(AboutPresenterImpl presenter) {
        return presenter;
    }

    @Provides
    @Singleton
    public AboutManager provideAboutManager(AboutManagerImpl aboutManager) {
        return aboutManager;
    }

    @Provides
    @Singleton
    public ProfileManager provideProfileManager(ProfileManagerImpl profileManager) {
        return profileManager;
    }
}
