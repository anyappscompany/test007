package ua.com.anyapps.test007.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.anyapps.test007.presenter.MainActivityFavoriteChannelsPresenter;

@Module
public class MainActivityFavoriteChannelsPresenterModule {
    @Provides
    @Singleton
    MainActivityFavoriteChannelsPresenter provideMainActivityFavoriteChannelsPresenter() {
        return new MainActivityFavoriteChannelsPresenter();
    }
}
