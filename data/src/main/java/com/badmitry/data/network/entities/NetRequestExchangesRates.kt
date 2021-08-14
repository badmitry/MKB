package com.badmitry.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NetRequestExchangesRates(
    @Expose @SerializedName("uid") val uid: String,
    @Expose @SerializedName("type") val type: String,
    @Expose @SerializedName("rid") val rid: String
) : Serializable
