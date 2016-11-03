package com.dmariani.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dmariani.mvp.MvpApplication;
import com.dmariani.mvp.R;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.presenter.AboutPresenter;
import com.dmariani.mvp.ui.view.AboutView;

import javax.inject.Inject;

/**
 * Activity that provides About Screen
 *
 * @author danielle.mariani
 */
public class AboutActivity extends AppCompatActivity implements AboutView {

    @Inject
    protected AboutPresenter presenter;

    private TextView textViewMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        // inject dependencies
        ((MvpApplication)getApplication()).getComponent().inject(this);

        // bind views
        textViewMessage = (TextView) findViewById(R.id.text_message);

        // execute presenter
        presenter.attachView(this);
        presenter.fetchProfile();
    }

    @Override
    public void onFetchProfile(User user) {
        if (user == null) {
            textViewMessage.setText("Null");
        } else {
            textViewMessage.setText(user.toString());
        }
    }

}