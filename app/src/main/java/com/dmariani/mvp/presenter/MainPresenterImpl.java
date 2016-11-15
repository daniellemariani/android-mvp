package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.MainView;

/**
 * It implements MainPresenter interface
 *
 * @author danielle.mariani
 */
public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    // TODO: manage this flag properly
    private boolean login;

    @Override
    public void onClickAboutItem() {
        view.navigateToAbout();
    }

    @Override
    public void onClickProfileItem() {
        if (login) {
            view.navigateToProfile();
        } else {
            view.navigateToLogin();
        }
    }

}
