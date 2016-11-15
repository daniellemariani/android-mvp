package com.dmariani.mvp.ui.view;

/**
 * MVP View which provides MainPresenter operations over the view
 *
 * @author danielle.mariani
 */

public interface MainView extends BaseView {

    void navigateToAbout();

    void navigateToLogin();

    void navigateToProfile();

}
