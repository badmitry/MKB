package com.badmitry.mkb.di.modules

import com.badmitry.domain.usecases.DownloadRatesUseCase
import com.badmitry.mkb.app.MKBApplication
import com.badmitry.mkb.ui.MainViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Singleton
    @Provides
    fun provideMainViewModule(
        app: MKBApplication,
        useCase: DownloadRatesUseCase
    ) = MainViewModel(app, useCase)
}