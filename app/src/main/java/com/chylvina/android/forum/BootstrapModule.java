package com.chylvina.android.forum;

import android.accounts.AccountManager;
import android.content.Context;

import com.chylvina.android.forum.authenticator.BootstrapAuthenticatorActivity;
import com.chylvina.android.forum.authenticator.LogoutService;
import com.chylvina.android.forum.core.CheckIn;
import com.chylvina.android.forum.core.TimerService;
import com.chylvina.android.forum.ui.BootstrapTimerActivity;
import com.chylvina.android.forum.ui.CarouselActivity;
import com.chylvina.android.forum.ui.CheckInsListFragment;
import com.chylvina.android.forum.ui.ItemListFragment;
import com.chylvina.android.forum.ui.NewsActivity;
import com.chylvina.android.forum.ui.NewsListFragment;
import com.chylvina.android.forum.ui.UserActivity;
import com.chylvina.android.forum.ui.UserListFragment;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
(
        complete = false,

        injects = {
                BootstrapApplication.class,
                BootstrapAuthenticatorActivity.class,
                CarouselActivity.class,
                BootstrapTimerActivity.class,
                CheckInsListFragment.class,
                NewsActivity.class,
                NewsListFragment.class,
                UserActivity.class,
                UserListFragment.class,
                TimerService.class
        }

)
public class BootstrapModule  {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
