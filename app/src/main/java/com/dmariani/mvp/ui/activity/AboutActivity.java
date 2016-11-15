package com.dmariani.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.dmariani.mvp.BuildConfig;
import com.dmariani.mvp.MvpApplication;
import com.dmariani.mvp.R;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.presenter.AboutPresenter;
import com.dmariani.mvp.ui.view.AboutView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity that provides About Screen
 *
 * @author danielle.mariani
 */
public class AboutActivity extends AppCompatActivity implements AboutView {

    @Inject
    protected AboutPresenter presenter;

    @BindView(R.id.imageview_avatar)
    ImageView imageAvatar;

    @BindView(R.id.textview_fullname)
    TextView textViewFullName;

    @BindView(R.id.textview_location)
    TextView textViewLocation;

    @BindView(R.id.textview_version)
    TextView textViewVersion;

    public static Intent createIntent(Context context) {
        return new Intent(context, AboutActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // inject dependencies
        ((MvpApplication)getApplication()).getComponent().inject(this);

        // bind views
        ButterKnife.bind(this);
        textViewVersion.setText(getString(R.string.app_version, BuildConfig.VERSION_NAME));

        // execute presenter
        presenter.attachView(this);
        presenter.fetchProfile();
    }

    @Override
    public void onFetchProfile(User user) {
        if (user != null) {
            Picasso.with(this).load(user.getAvatarUrl())
                    .placeholder(android.R.drawable.sym_def_app_icon)
                    .error(android.R.drawable.sym_def_app_icon)
                    .into(imageAvatar);
            textViewFullName.setText(getString(R.string.app_author, user.getName()));
            textViewLocation.setText(user.getLocation());
        }
    }

}