package ua.com.anyapps.test007.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.anyapps.test007.presenter.MainActivitySearchNewsPresenter;

@Module
public class MainActivitySearchNewsPresenterModule {
    @Provides
    @Singleton
    MainActivitySearchNewsPresenter provideMainActivitySearchNewsPresenter() {
        return new MainActivitySearchNewsPresenter();
    }
}
