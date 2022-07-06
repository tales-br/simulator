package br.tales.simulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//data class já cria automáticamente os getters e setters!
@Parcelize
data class Match
(
    @SerializedName("description")  val description: String,
    @SerializedName("local")        val local: Place,
    @SerializedName("home")         val homeTeam: Team,
    @SerializedName("away")         val awayTeam: Team
) : Parcelable