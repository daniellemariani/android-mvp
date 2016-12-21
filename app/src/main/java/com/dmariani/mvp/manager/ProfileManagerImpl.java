package com.dmariani.mvp.manager;

import com.dmariani.mvp.api.GitHubApiClient;
import com.dmariani.mvp.model.User;

import javax.inject.Inject;

import rx.Observable;

/**
 * It implements ProfileManager interface
 *
 * @author danielle.mariani
 */

public class ProfileManagerImpl implements ProfileManager {

    private boolean login;
    private GitHubApiClient gitHubApiClient;

    @Inject
    public ProfileManagerImpl(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    @Override
    public Observable<User> login(String username) {
        return gitHubApiClient.getUser(username);
    }

    public boolean isUserLoggedIn() {
        return login;
    }

    public void setUserLoggedIn(boolean login) {
        this.login = login;
    }
}
