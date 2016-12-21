package com.dmariani.mvp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dmariani.mvp.MvpApplication;
import com.dmariani.mvp.R;
import com.dmariani.mvp.manager.ProfileManager;
import com.dmariani.mvp.model.User;
import com.dmariani.mvp.presenter.MainPresenter;
import com.dmariani.mvp.ui.fragment.LoginFragment;
import com.dmariani.mvp.ui.view.MainView;
import com.dmariani.mvp.utils.RxBus;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * @author danielle.mariani
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @Inject
    protected MainPresenter presenter;

    @Inject
    protected RxBus bus;

    private Subscription busSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // inject dependencies
        ((MvpApplication) getApplication()).getComponent().inject(this);

        // init presenter
        presenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        subscribeBus();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unsubscribeBus();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        presenter.onClickMenuItem(item.getItemId());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setContentFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_content, fragment)
                .commit();
    }

    /**
     * RxBus
     */

    private void subscribeBus() {
        busSubscription = bus.getObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Action1<Object>() {
                            @Override
                            public void call(Object object) {
                                handlerBus(object);
                            }
                        }
                );
    }

    private void unsubscribeBus() {
        if (busSubscription != null && !busSubscription.isUnsubscribed()) {
            busSubscription.unsubscribe();
        }
    }

    private void handlerBus(Object object) {
        if (object instanceof ProfileManager.ProfileEvent) {
            User user = ((ProfileManager.ProfileEvent) object).getUser();
            Toast.makeText(this, "User: " + user.getName(), Toast.LENGTH_SHORT).show();
            // TODO: replace login fragment
        }
    }

    /**
     * Main View
     */

    @Override
    public void navigateToAbout() {
        startActivity(AboutActivity.createIntent(this));
    }

    @Override
    public void navigateToLogin() {
         setContentFragment(LoginFragment.newInstance());
    }

    @Override
    public void navigateToProfile() {
        // do something
    }

    @Override
    public void onError(int errorMessage) {
        // do nothing
    }
}
