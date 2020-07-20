package ua.com.anyapps.test007.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.anyapps.test007.presenter.MainActivityAllChannelsPresenter;

@Module
public class MainActivityAllChannelsPresenterModule {
    @Provides
    @Singleton
    MainActivityAllChannelsPresenter provideMainActivityAllChannelsPresenter() {
        return new MainActivityAllChannelsPresenter();
    }
}
