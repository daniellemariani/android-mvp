package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.MainView;

/**
 * Presenter which provides MainView actions
 *
 * @author danielle.mariani
 */

public interface MainPresenter extends BasePresenter<MainView> {

    /**
     * It handles About click operation
     */
    void onClickAboutItem();

    /**
     * It handles Profile click operation
     */
    void onClickProfileItem();
}
