package com.dmariani.mvp.manager;

import com.dmariani.mvp.model.User;

import rx.Observable;

/**
 * It defines operations to manage user's Profile
 *
 * @author danielle.mariani
 */

public interface ProfileManager {

    Observable<User> login(String username);

    boolean isUserLoggedIn();

    void setUserLoggedIn(boolean login);

    class ProfileEvent {

        private final User user;

        public ProfileEvent(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }
    }
}
