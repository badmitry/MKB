package com.badmitry.mkb.di

import com.badmitry.mkb.di.modules.AppModule
import com.badmitry.mkb.di.modules.NetworkModule
import com.badmitry.mkb.di.modules.UseCaseModule
import com.badmitry.mkb.di.modules.ViewModelModule
import com.badmitry.mkb.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
}