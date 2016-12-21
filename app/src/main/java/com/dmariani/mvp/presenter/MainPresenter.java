package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.MainView;

/**
 * Presenter which provides MainView actions
 *
 * @author danielle.mariani
 */

public interface MainPresenter extends BasePresenter<MainView> {

    void onClickMenuItem(int id);
}
