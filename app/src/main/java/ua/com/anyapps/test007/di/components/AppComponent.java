package ua.com.anyapps.test007.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.anyapps.test007.di.module.AppModule;
import ua.com.anyapps.test007.di.module.MainActivityAllChannelsPresenterModule;
import ua.com.anyapps.test007.di.module.MainActivityFavoriteChannelsPresenterModule;
import ua.com.anyapps.test007.di.module.MainActivitySearchNewsPresenterModule;
import ua.com.anyapps.test007.di.module.NetworkModule;
import ua.com.anyapps.test007.model.MainActivityAllChannelsModel;
import ua.com.anyapps.test007.presenter.MainActivityAllChannelsPresenter;
import ua.com.anyapps.test007.ui.fragments.MainActivityAllChannelsFragment;
import ua.com.anyapps.test007.ui.fragments.MainActivityFavoriteChannelsFragment;
import ua.com.anyapps.test007.ui.fragments.MainActivitySearchNewsFragment;

//@Component(modules = {AppModule.class, MainActivityAllChannelsPresenterModule.class, MainActivityFavoriteChannelsPresenterModule.class, MainActivitySearchNewsPresenterModule.class})
@Component(modules = {AppModule.class, MainActivityAllChannelsPresenterModule.class, MainActivityFavoriteChannelsPresenterModule.class, MainActivitySearchNewsPresenterModule.class, NetworkModule.class})

@Singleton
public interface AppComponent {
    //void inject(MainActivity mainActivity);
    void inject(MainActivityAllChannelsFragment mainActivityAllChannelsFragment);
    void inject(MainActivityFavoriteChannelsFragment mainActivityFavoriteChannelsFragment);
    void inject(MainActivitySearchNewsFragment mainActivitySearchNewsFragment);
    void inject(MainActivityAllChannelsModel mainActivityAllChannelsModel);
}
