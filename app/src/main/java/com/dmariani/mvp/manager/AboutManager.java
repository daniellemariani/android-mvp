package com.dmariani.mvp.manager;

import com.dmariani.mvp.model.User;

import rx.Observable;

/**
 * It defines operations to manage About data
 *
 * @author danielle.mariani
 */

public interface AboutManager {

    /**
     * It makes a request to get my Own GitHub Profile
     * @return
     */
    Observable<User> fetchProfile();
}
