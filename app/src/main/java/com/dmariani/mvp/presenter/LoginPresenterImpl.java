package com.dmariani.mvp.presenter;

import android.text.TextUtils;

import com.dmariani.mvp.R;
import com.dmariani.mvp.manager.ProfileManager;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.ui.view.LoginView;
import com.dmariani.mvp.utils.NLog;
import com.dmariani.mvp.utils.RxBus;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author danielle.mariani
 */

public class LoginPresenterImpl extends BasePresenterImpl<LoginView> implements LoginPresenter {

    private ProfileManager profileManager;
    private RxBus bus;

    @Inject
    public LoginPresenterImpl(ProfileManager profileManager, RxBus bus) {
        this.profileManager = profileManager;
        this.bus = bus;
    }

    @Override
    public void login(String username) {

        if (TextUtils.isEmpty(username)){
            view.onError(R.string.error_invalid_username);
            return;
        }

        if (profileManager.isUserLoggedIn()){
            view.onError(R.string.error_already_logged_in);
            return;
        }

        view.showLoader();
        profileManager.login(username)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onCompleted() {
                        view.hideLoader();
                    }

                    @Override
                    public void onError(Throwable e) {
                        NLog.failed();
                        NLog.e(e);
                        view.onError(R.string.error_server_login);
                    }

                    @Override
                    public void onNext(User user) {
                        profileManager.setUserLoggedIn(true);
                        bus.send(new ProfileManager.ProfileEvent(user));
                    }
                });
    }
}
