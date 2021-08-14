package com.badmitry.mkb.di.modules

import com.badmitry.domain.repositories.INetworkRepo
import com.badmitry.domain.usecases.DownloadRatesUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideUseCase(networkRepo: INetworkRepo) = DownloadRatesUseCase(networkRepo)

}
