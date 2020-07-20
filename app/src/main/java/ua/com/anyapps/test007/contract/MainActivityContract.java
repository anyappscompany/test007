package ua.com.anyapps.test007.contract;

import java.util.List;

import ua.com.anyapps.test007.network.ApiService;
import ua.com.anyapps.test007.pojo.sources.Sources;

public interface MainActivityContract {
    interface MainActivityAllChannelsFragmentView {
        void showLoader();
        void hideLoader();
        void onGetDataSuccess(List<Sources> allSources);
    }
    interface MainActivityFavoriteChannelsFragmentView {
        void test();
    }
    interface MainActivitySearchNewsFragmentView {
        void test();
    }

    interface MainActivityAllChannelsPresenter {
        void onDestroy();
        void onCreate();
        void attachView(MainActivityContract.MainActivityAllChannelsFragmentView mView);
        void attachNetworkClient(ApiService serverApiClient, String newsApiKey);
    }
    interface MainActivityFavoriteChannelsPresenter {
        void onDestroy();
        void onCreate();
        void attachView(MainActivityFavoriteChannelsFragmentView mView);
        void attachNetworkClient(ApiService serverApiClient, String newsApiKey);
    }
    interface MainActivitySearchNewsPresenter {
        void onDestroy();
        void onCreate();
        void attachView(MainActivityContract.MainActivitySearchNewsFragmentView mView);
        void attachNetworkClient(ApiService serverApiClient, String newsApiKey);
    }

    interface MainActivityAllChannelsModel{
        interface OnFinishedListener {
            void onFinished(List<Sources> sourcesArrayList);
            void onFailure(Throwable t);
        }
        void getSourcesList(OnFinishedListener onFinishedListener);
        void attachNetworkClient(ApiService serverApiClient, String newsApiKey);
    }
    interface MainActivityFavoriteChannelsModel {
        void test();
    }
    interface MainActivitySearchNewsModel{
        void test();
    }
}
