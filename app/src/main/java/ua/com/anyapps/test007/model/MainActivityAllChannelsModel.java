package ua.com.anyapps.test007.model;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.anyapps.test007.contract.MainActivityContract;
import ua.com.anyapps.test007.network.ApiService;
import ua.com.anyapps.test007.pojo.sources.Sources;
import ua.com.anyapps.test007.pojo.sources.SourcesNews;

public class MainActivityAllChannelsModel implements MainActivityContract.MainActivityAllChannelsModel, Callback<SourcesNews> {
    private ApiService serverApiClient;
    private String newsApiKey;
    private OnFinishedListener onFinishedListener;
    private static final String TAG = "debapp";
    @Override
    public void getSourcesList(final OnFinishedListener onFinishedListener) {
        serverApiClient.getSourcesNews(newsApiKey).enqueue(this);
        this.onFinishedListener = onFinishedListener;
    }

    @Override
    public void attachNetworkClient(ApiService serverApiClient, String newsApiKey) {
        this.serverApiClient = serverApiClient;
        this.newsApiKey = newsApiKey;
    }

    @Override
    public void onResponse(Call<SourcesNews> call, Response<SourcesNews> response) {
        List<Sources> sources = new ArrayList<>();
        if(response.isSuccessful()){
            onFinishedListener.onFinished(Arrays.asList(response.body().getSources()));
        }else {
            onFinishedListener.onFinished(sources);
        }
    }

    @Override
    public void onFailure(Call<SourcesNews> call, Throwable t) {
        onFinishedListener.onFailure(t);
    }
}
