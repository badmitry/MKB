package com.badmitry.domain.entities

data class ExchangeRates(
    val tp: Int,
    val name: String,
    val from: Int,
    val currMnemFrom: String,
    val to: Int,
    val currMnemTo: String,
    val basic: String,
    val buy: String,
    val sale: String,
    val deltaBuy: String,
    val deltaSale: String
)