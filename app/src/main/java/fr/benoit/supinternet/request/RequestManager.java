package fr.benoit.supinternet.request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Singleton used by the controller to fetch data from the network
 *
 * Created by benoit on 06/02/2016.
 */
public class RequestManager {

    private static final String API_BASE_URL = "https://api.github.com/";

    private static RequestManager sInstance = null;

    private static Object _lock = new Object();

    private Retrofit retrofit;

    public static RequestManager getInstance(){
        if (sInstance == null){
            synchronized (_lock){
                if (sInstance == null){
                    sInstance = new RequestManager();
                }
            }
        }
        return sInstance;
    }

    private RequestManager(){

    }

    public void searchRepositories(String query, Callback<RequestRepositories> callback){

        Retrofit retrofit = getRetrofit();

        RepositoryService repositoryService = retrofit.create(RepositoryService.class);
        Call<RequestRepositories> data = repositoryService.searchRepositories(query);
        data.enqueue(callback);
    }

    private Retrofit getRetrofit(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(API_BASE_URL)
                    .build();
        }
        return retrofit;
    }
}
