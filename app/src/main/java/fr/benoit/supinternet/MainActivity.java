package fr.benoit.supinternet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import fr.benoit.supinternet.request.RequestManager;
import fr.benoit.supinternet.request.RequestRepositories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Activity displaying the EditText and the list of results
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrieveViews();

    }

    private void retrieveViews(){

    }

    private void fetchData(String query){
        RequestManager.getInstance().searchRepositories(query, new Callback<RequestRepositories>() {
            @Override
            public void onResponse(Call<RequestRepositories> call, Response<RequestRepositories> response) {
                Toast.makeText(MainActivity.this, "Repositories retrieved " + response.body().getRepositories().size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RequestRepositories> call, Throwable t) {
                Toast.makeText(MainActivity.this, R.string.activity_main_search_network_error, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
