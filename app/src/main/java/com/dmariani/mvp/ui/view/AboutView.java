package com.dmariani.mvp.ui.view;

import com.dmariani.mvp.model.User;

/**
 * MVP View which defines AboutPresenter notifications
 *
 * @author danielle.mariani
 */

public interface AboutView extends BaseView {

    void onFetchProfile(User user);

}
