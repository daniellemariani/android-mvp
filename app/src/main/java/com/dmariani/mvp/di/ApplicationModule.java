package com.dmariani.mvp.di;

import com.dmariani.mvp.api.ApiConstants;
import com.dmariani.mvp.api.GitHubApiClient;
import com.dmariani.mvp.manager.AboutManager;
import com.dmariani.mvp.manager.AboutManagerImpl;
import com.dmariani.mvp.presenter.AboutPresenter;
import com.dmariani.mvp.presenter.AboutPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
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
                .build();

        return retrofit.create(GitHubApiClient.class);
    }

    @Provides
    @Singleton
    public AboutManager provideAboutManager(AboutManagerImpl aboutManager) {
        return aboutManager;
    }

    @Provides
    @Singleton
    public AboutPresenter provideAboutPresenter(AboutPresenterImpl presenter) {
        return presenter;
    }
}
