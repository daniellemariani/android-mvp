package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.BaseView;

/**
 * Base MVP Presenter which defines base MVP view operations
 * @author danielle.mariani
 */

public interface BasePresenter <BV extends BaseView> {

    void attachView(BV view);

    boolean isViewAttached();

    void detachView();

    BV getView();

}
