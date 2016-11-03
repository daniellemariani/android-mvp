package com.dmariani.mvp.api;

import com.dmariani.mvp.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * API Client that defines GitHub Service operations
 *
 * @author danielle.mariani
 */

public interface GitHubApiClient {

    @Headers({
            ApiConstants.Headers.ACCEPT_GITUB_V3,
            ApiConstants.Headers.USER_AGENT
    })
    @GET(ApiConstants.USER_PROFILE_PATH)
    Call<User> getUser(@Path(ApiConstants.Params.USERNAME) String username);
}
