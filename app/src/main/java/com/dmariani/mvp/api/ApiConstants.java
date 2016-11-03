package com.dmariani.mvp.api;

/**
 * It provides Api Constants as: URLs, Headers, Params, etc.
 *
 * @author danielle.mariani
 */
public interface ApiConstants {

    String BASE_URL = "https://api.github.com";
    String USER_PROFILE_PATH = "/users/{username}";

    interface Headers {
        String ACCEPT_GITUB_V3 = "Accept: application/vnd.github.v3.full+json";
        String USER_AGENT = "User-Agent: Android-MVP-App";
    }

    interface Params {
        String USERNAME = "username";
    }
}
