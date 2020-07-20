package ua.com.anyapps.test007.di;

import android.app.Application;
import android.content.Context;

import ua.com.anyapps.test007.di.components.AppComponent;
import ua.com.anyapps.test007.di.components.DaggerAppComponent;
import ua.com.anyapps.test007.di.module.AppModule;

public class App extends Application {

    private static AppComponent appComponent;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();

        context = getApplicationContext();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Context getContext(){
        return context;
    }
}
