package ua.com.anyapps.test007.presenter;

import android.util.Log;

import java.util.List;

import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.model.MainActivityAllChannelsModel;
import ua.com.anyapps.test007.network.ApiService;
import ua.com.anyapps.test007.pojo.sources.Sources;

public class MainActivityAllChannelsPresenter implements MainActivityContract.MainActivityAllChannelsPresenter, MainActivityContract.MainActivityAllChannelsModel.OnFinishedListener {
    private static final String TAG = "debapp";

    //Компоненты MVP приложения
    private MainActivityContract.MainActivityAllChannelsFragmentView mView;
    private MainActivityContract.MainActivityAllChannelsModel mModel;
    private ApiService serverApiClient;
    private String newsApiKey;

    public MainActivityAllChannelsPresenter() {
        this.mModel = new MainActivityAllChannelsModel();
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
    public void onCreate() {
        mView.showLoader();
        mModel.getSourcesList(this);
    }

    @Override
    public void attachView(MainActivityContract.MainActivityAllChannelsFragmentView mView) {
        this.mView = mView;
    }

    @Override
    public void attachNetworkClient(ApiService serverApiClient, String newsApiKey) {
        this.serverApiClient = serverApiClient;
        this.newsApiKey = newsApiKey;
        mModel.attachNetworkClient(serverApiClient, newsApiKey);
        //serverApiClient.getSourcesNews(newsApiKey).enqueue(this);
    }

    @Override
    public void onFinished(List<Sources> sourcesArrayList) {
        mView.hideLoader();
        Log.d(TAG, ">>>>>+++"+ sourcesArrayList.size());
        mView.onGetDataSuccess(sourcesArrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        mView.hideLoader();
        Log.d(TAG, ">>>>>+++"+"Error " + t.getMessage());
    }
}
