package com.example.weatherapp5.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private var application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return this.application
    }


}