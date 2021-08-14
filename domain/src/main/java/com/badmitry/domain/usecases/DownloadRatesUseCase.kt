package com.badmitry.domain.usecases

import com.badmitry.domain.entities.ResponseData
import com.badmitry.domain.repositories.INetworkRepo
import io.reactivex.Single
import javax.inject.Inject

class DownloadRatesUseCase @Inject constructor(
    private val networkRepo: INetworkRepo
) {
    fun getExchangeRates(uid: String, type: String, rid: String): Single<ResponseData> =
        networkRepo.getExchangesRates(uid, type, rid)
}