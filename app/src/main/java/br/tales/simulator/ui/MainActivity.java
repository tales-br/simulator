package br.tales.simulator.ui;

import static android.os.Build.VERSION_CODES.R;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import java.util.List;

import br.tales.simulator.R;
import br.tales.simulator.data.MatchesAPI;
import br.tales.simulator.databinding.ActivityMainBinding;
import br.tales.simulator.domain.Match;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity
{
    private ActivityMainBinding binding;
    private MatchesAPI matchesApi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupHttpClient();
        setupMatchesList();
        MatchesRefresh();
        SetupFloatingActionButton();
    }

    private void setupHttpClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://tales-br.github.io/simulator-api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        matchesApi = retrofit.create(MatchesAPI.class);
    }

    private void setupMatchesList()
    {
        matchesApi.getMatches().enqueue(new Callback<List<Match>>()
        {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response)
            {
                if(response.isSuccessful())
                {
                    List<Match> matches = response.body();
                }
                else
                {
                    errorMessage();
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t)
            {
                errorMessage();
            }
        });
    }

    private void MatchesRefresh()
    {
        //TODO: dar refresh nas partidas com o swipe da tela
    }

    private void SetupFloatingActionButton()
    {
        //TODO: adicionar acção no botão pra randomizar as partidas
    }

    private void errorMessage()
    {
        Snackbar.make
                (
                        binding.fabSimulate,
                        br.tales.simulator.R.string.error_api,
                        Snackbar.LENGTH_LONG
                ).show();
    }
}

