package com.dmariani.mvp.ui.view;

import com.dmariani.mvp.model.User;

/**
 * @author danielle.mariani
 */

public interface LoginView extends BaseView {

    void onLogin(User user);
}
