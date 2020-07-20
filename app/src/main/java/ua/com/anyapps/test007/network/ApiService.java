package ua.com.anyapps.test007.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.com.anyapps.test007.pojo.sources.SourcesNews;

public interface ApiService {
    @GET("sources")
    Call<SourcesNews> getSourcesNews(@Query("apiKey") String apikey);
}
