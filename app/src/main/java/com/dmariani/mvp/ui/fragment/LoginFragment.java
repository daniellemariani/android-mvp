package com.dmariani.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.dmariani.mvp.MvpApplication;
import com.dmariani.mvp.R;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.presenter.LoginPresenter;
import com.dmariani.mvp.ui.view.LoginView;
import com.dmariani.mvp.utils.RxBus;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fragment that allows user to login through GitHub
 *
 * @author danielle.mariani
 */
public class LoginFragment extends Fragment implements LoginView {

    @Inject
    protected LoginPresenter presenter;

    @Inject
    protected RxBus bus;

    @BindView(R.id.edittext_username)
    EditText editTextUsername;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        // Bind views
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // inject dependencies
        ((MvpApplication) getActivity().getApplication()).getComponent().inject(this);

        // init presenter
        presenter.attachView(this);
    }

    @OnClick(R.id.button)
    public void onContinueButtonClick() {
        presenter.login(editTextUsername.getText().toString());
    }

    @Override
    public void onLogin(User user) {
        Toast.makeText(getContext(), "Login Ok", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int errorMessage) {
        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }
}
