package com.dmariani.mvp.manager;

import com.dmariani.mvp.api.GitHubApiClient;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.utils.NLog;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    public String fetchProfile() throws IOException {

        Call<User> call = gitHubApiClient.getUser(USERNAME);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                NLog.success();
                NLog.result(response.body().toString());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                NLog.failed();
                NLog.e(t);
            }
        });

        return "Hola Mundo!";
    }
}
