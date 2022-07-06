package br.tales.simulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team
(
  @SerializedName("name")   val name:String,
  @SerializedName("power")  val stars: Int,
  @SerializedName("image")  val image: String,
  var score: Int?
) : Parcelable
