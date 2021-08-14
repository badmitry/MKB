package com.badmitry.data.mapers

import com.badmitry.data.network.entities.NetResponseRates
import com.badmitry.domain.entities.ExchangeRates
import com.badmitry.domain.entities.ResponseData

object ExchangeRatesMapper {
    fun convertFromNetwork(netResponse: NetResponseRates): ResponseData {
        val exchangeRatesList = mutableListOf<ExchangeRates>()
        netResponse.rates.forEach { response ->
            exchangeRatesList.add(
                ExchangeRates(
                    response.tp,
                    response.name,
                    response.from,
                    response.currMnemFrom,
                    response.to,
                    response.currMnemTo,
                    response.basic,
                    response.buy,
                    response.sale,
                    response.deltaBuy,
                    response.deltaSale
                )
            )
        }
        return ResponseData(
            netResponse.code,
            netResponse.messageTitle,
            netResponse.message,
            netResponse.rid,
            netResponse.downloadDate,
            exchangeRatesList,
            netResponse.productState,
            netResponse.ratesDate
        )
    }
}