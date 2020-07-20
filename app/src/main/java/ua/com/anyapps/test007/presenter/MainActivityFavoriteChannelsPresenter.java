package ua.com.anyapps.test007.presenter;

import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.model.MainActivityFavoriteChannelsModel;
import ua.com.anyapps.test007.network.ApiService;

public class MainActivityFavoriteChannelsPresenter implements MainActivityContract.MainActivityFavoriteChannelsPresenter {
    private static final String TAG = "debapp";

    //Компоненты MVP приложения
    private MainActivityContract.MainActivityFavoriteChannelsFragmentView mView;
    private MainActivityContract.MainActivityFavoriteChannelsModel mModel;

    private ApiService serverApiClient;
    private String newsApiKey;
    public MainActivityFavoriteChannelsPresenter() {
        this.mModel = new MainActivityFavoriteChannelsModel();
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
    public void onCreate() {
        //
    }

    @Override
    public void attachView(MainActivityContract.MainActivityFavoriteChannelsFragmentView mView) {
        this.mView = mView;
    }

    @Override
    public void attachNetworkClient(ApiService serverApiClient, String newsApiKey) {
        this.serverApiClient = serverApiClient;
        this.newsApiKey = newsApiKey;
    }
}