package com.example.weatherapp.root

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(application: Application) {

    var application: Application

    init {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideContext(): Context {
        return this.application
    }


}