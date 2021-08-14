package com.badmitry.mkb.app

import android.app.Application
import com.badmitry.mkb.di.AppComponent
import com.badmitry.mkb.di.DaggerAppComponent
import com.badmitry.mkb.di.modules.AppModule
import io.reactivex.plugins.RxJavaPlugins

class MKBApplication : Application() {
    companion object {
        lateinit var instance: MKBApplication
        val component get() = instance._appComponent
    }

    private lateinit var _appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { throwable: Throwable? -> {} }
        instance = this
        _appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}