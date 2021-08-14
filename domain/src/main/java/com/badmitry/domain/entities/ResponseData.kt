package com.badmitry.domain.entities

data class ResponseData(
    val code: Int,
    val messageTitle: String,
    val message: String,
    val rid: String,
    val downloadDate: String,
    val rates: List<ExchangeRates>,
    val productState: Int,
    val ratesDate: String
)