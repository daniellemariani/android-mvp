package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.AboutView;

/**
 * Presenter which provides AboutView actions
 *
 * @author danielle.mariani
 */

public interface AboutPresenter extends BasePresenter<AboutView> {

    /**
     * It gets my own GitHub Profile
     */
    void fetchProfile();

}
