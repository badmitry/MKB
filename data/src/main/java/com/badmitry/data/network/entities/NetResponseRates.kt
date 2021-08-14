package com.badmitry.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NetResponseRates(
    @Expose
    @SerializedName("code")
    val code: Int,
    @Expose
    @SerializedName("messageTitle")
    val messageTitle: String,
    @Expose
    @SerializedName("message")
    val message: String,
    @Expose
    @SerializedName("rid")
    val rid: String,
    @Expose
    @SerializedName("downloadDate")
    val downloadDate: String,
    @Expose
    @SerializedName("rates")
    val rates: List<NetRates>,
    @Expose
    @SerializedName("productState")
    val productState: Int,
    @Expose
    @SerializedName("ratesDate")
    val ratesDate: String
)