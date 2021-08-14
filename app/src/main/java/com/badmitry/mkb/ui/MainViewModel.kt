package com.badmitry.mkb.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.badmitry.domain.entities.ResponseData
import com.badmitry.domain.usecases.DownloadRatesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    app: Application,
    private val useCase: DownloadRatesUseCase,
) : AndroidViewModel(app) {

    private val compositeDisposable = CompositeDisposable()

    private val answerLiveData = MutableLiveData<ResponseData>()
    fun getAnswerLiveData() = answerLiveData

    fun downloadExchangeRates(uid: String, type: String, rid: String) {
        useCase.getExchangeRates(uid, type, rid)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                answerLiveData.postValue(it)
            }, {
                it.message?.let { message -> Log.d("!!!", message) }
            }).addTo(compositeDisposable)
    }

    public override fun onCleared() {
        compositeDisposable.dispose()
    }
}