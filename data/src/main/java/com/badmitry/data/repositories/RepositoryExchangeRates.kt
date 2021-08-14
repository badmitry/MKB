package com.badmitry.data.repositories

import com.badmitry.data.mapers.ExchangeRatesMapper
import com.badmitry.data.network.api.ApiExchangeRates
import com.badmitry.data.network.entities.NetRequestExchangesRates
import com.badmitry.domain.entities.ResponseData
import com.badmitry.domain.repositories.INetworkRepo
import io.reactivex.Single

class RepositoryExchangeRates(private val api: ApiExchangeRates) : INetworkRepo {

    override fun getExchangesRates(
        uid: String, type: String, rid: String
    ): Single<ResponseData> {
        return api.getExchangeRates(NetRequestExchangesRates(uid, type, rid))
            .map { ExchangeRatesMapper.convertFromNetwork(it) }
    }

}