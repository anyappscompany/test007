package ua.com.anyapps.test007.presenter;

import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.model.MainActivitySearchNewsModel;
import ua.com.anyapps.test007.network.ApiService;

public class MainActivitySearchNewsPresenter implements MainActivityContract.MainActivitySearchNewsPresenter {
    private static final String TAG = "debapp";

    //Компоненты MVP приложения
    private MainActivityContract.MainActivitySearchNewsFragmentView mView;
    private MainActivityContract.MainActivitySearchNewsModel mModel;

    private ApiService serverApiClient;
    private String newsApiKey;

    public MainActivitySearchNewsPresenter() {
        this.mModel = new MainActivitySearchNewsModel();
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
    public void attachView(MainActivityContract.MainActivitySearchNewsFragmentView mView) {
        this.mView = mView;
    }

    @Override
    public void attachNetworkClient(ApiService serverApiClient, String newsApiKey) {
        this.serverApiClient = serverApiClient;
        this.newsApiKey = newsApiKey;
    }


}