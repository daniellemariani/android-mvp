package com.dmariani.mvp.presenter;

import com.dmariani.mvp.manager.AboutManager;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.ui.view.AboutView;
import com.dmariani.mvp.utils.NLog;

import java.io.IOException;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

        aboutManager.fetchProfile()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        NLog.failed();
                        NLog.e(e);
                    }

                    @Override
                    public void onNext(User user) {
                        NLog.success();
                        NLog.result(user.toString());
                        getView().onFetchProfile(user);
                    }
                });

    }
}
