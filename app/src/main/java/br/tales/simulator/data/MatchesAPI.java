package br.tales.simulator.data;

import br.tales.simulator.domain.Match;

import java.util.*;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesAPI
{
    @GET("matches.json")
    Call<List<Match>> getMatches();
}
