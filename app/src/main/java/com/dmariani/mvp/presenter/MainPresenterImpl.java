package com.dmariani.mvp.presenter;

import com.dmariani.mvp.R;
import com.dmariani.mvp.manager.ProfileManager;
import com.dmariani.mvp.ui.view.MainView;

import javax.inject.Inject;

/**
 * It implements MainPresenter interface
 *
 * @author danielle.mariani
 */
public class MainPresenterImpl extends BasePresenterImpl<MainView> implements MainPresenter {

    private ProfileManager profileManager;

    @Inject
    public MainPresenterImpl(ProfileManager profileManager){
        this.profileManager = profileManager;
    }

    @Override
    public void onClickMenuItem(int id) {
        if (id == R.id.nav_home) {
            // do something
        } else if (id == R.id.nav_explore) {

        } else if (id == R.id.nav_profile) {
            if (profileManager.isUserLoggedIn()) {
                view.navigateToProfile();
            } else {
                view.navigateToLogin();
            }
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_about) {
            view.navigateToAbout();
        }
    }

}
