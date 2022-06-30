package br.tales.simulator.domain

import com.google.gson.annotations.SerializedName

data class Match
    (
    @SerializedName("description")  val description: String,
    @SerializedName("local")        val local: Place,
    @SerializedName("home")         val homeTeam: Team,
    @SerializedName("away")         val awayTeam: Team
    )
