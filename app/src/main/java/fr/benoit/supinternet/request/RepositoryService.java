package fr.benoit.supinternet.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface used by Retrofit to create the request sent to the network
 *
 * Created by benoit on 06/02/2016.
 */
public interface RepositoryService {

    @GET("search/repositories")
    public Call<RequestRepositories> searchRepositories(@Query("q") String query);
}
