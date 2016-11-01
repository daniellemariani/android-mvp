package com.dmariani.mvp.presenter;

import com.dmariani.mvp.manager.AboutManager;
import com.dmariani.mvp.ui.view.AboutView;

import javax.inject.Inject;

/**
 * It implements AboutPresenter interface
 * @author danielle.mariani
 */

public class AboutPresenterImpl extends BasePresenterImpl<AboutView> implements AboutPresenter {

    private AboutManager aboutManager;

    @Inject
    public AboutPresenterImpl(AboutManager aboutManager) {
        this.aboutManager = aboutManager;
    }

    @Override
    public void fetchProfile() {
        String result = aboutManager.fetchProfile();
        getView().onFetchProfile(result);
    }
}
