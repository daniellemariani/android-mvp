package com.dmariani.mvp.presenter;

import com.dmariani.mvp.ui.view.BaseView;

/**
 * It implements BasePresenter to manage BaseView objects
 * 
 * @author danielle.mariani
 */

public class BasePresenterImpl <BV extends BaseView> implements BasePresenter<BV> {

    protected BV view;

    @Override
    public void attachView(BV view) {
        this.view = view;
    }

    @Override
    public boolean isViewAttached() {
        return this.view != null;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

}
