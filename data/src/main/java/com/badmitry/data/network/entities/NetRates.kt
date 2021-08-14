package com.badmitry.data.network.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NetRates (
    @Expose
    @SerializedName("tp") val tp: Int,
    @Expose
    @SerializedName("name") val name: String,
    @Expose
    @SerializedName("from") val from: Int,
    @Expose
    @SerializedName("currMnemFrom") val currMnemFrom: String,
    @Expose
    @SerializedName("to") val to: Int,
    @Expose
    @SerializedName("currMnemTo") val currMnemTo: String,
    @Expose
    @SerializedName("basic") val basic: String,
    @Expose
    @SerializedName("buy") val buy: String,
    @Expose
    @SerializedName("sale") val sale: String,
    @Expose
    @SerializedName("deltaBuy") val deltaBuy: String,
    @Expose
    @SerializedName("deltaSale") val deltaSale: String
    ) : Serializable