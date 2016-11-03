package com.dmariani.mvp.manager;

import com.dmariani.mvp.api.GitHubApiClient;
import com.dmariani.mvp.model.User;

import javax.inject.Inject;

import rx.Observable;

/**
 * It implements AboutManager interface
 * 
 * @author danielle.mariani
 */

public class AboutManagerImpl implements AboutManager {

    private static final String USERNAME = "daniellemariani";
    private GitHubApiClient gitHubApiClient;

    @Inject
    public AboutManagerImpl(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    @Override
    public Observable<User> fetchProfile() {
        return gitHubApiClient.getUser(USERNAME);
    }
}
