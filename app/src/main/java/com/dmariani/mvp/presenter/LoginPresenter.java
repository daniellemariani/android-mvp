package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.LoginView;

/**
 * @author danielle.mariani
 */

public interface LoginPresenter extends BasePresenter<LoginView> {

    void login(String username);
}
