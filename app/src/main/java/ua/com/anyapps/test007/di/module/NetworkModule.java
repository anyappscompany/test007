package ua.com.anyapps.test007.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.com.anyapps.test007.network.ApiService;

@Module
public class NetworkModule {
    private static final String BASE_URL = "https://newsapi.org/v2/";
    @Provides
    @Singleton
    ApiService provideRestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }
}
