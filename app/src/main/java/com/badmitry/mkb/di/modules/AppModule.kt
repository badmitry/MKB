package com.badmitry.mkb.di.modules

import com.badmitry.mkb.app.MKBApplication
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class AppModule(private val app: MKBApplication) {

    @Singleton
    @Provides
    fun app() = app

    @Singleton
    @Provides
    fun getSchedulers(): Scheduler? = AndroidSchedulers.mainThread()
}
