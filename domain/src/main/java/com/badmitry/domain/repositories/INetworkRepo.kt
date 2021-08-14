package com.badmitry.domain.repositories

import com.badmitry.domain.entities.ResponseData
import io.reactivex.Single

interface INetworkRepo {
    fun getExchangesRates(uid: String, type: String, rid: String): Single<ResponseData>
}