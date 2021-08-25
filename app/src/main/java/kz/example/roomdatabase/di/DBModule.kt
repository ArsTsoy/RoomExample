package kz.example.roomdatabase.di

import android.app.Application
import dagger.Module
import dagger.Provides
import kz.example.roomdatabase.MyDatabase
import javax.inject.Singleton


@Module
class DBModule(
    private val app: Application
) {

    @Provides
    @Singleton
    fun providesDB(): MyDatabase {
        return MyDatabase.getInstance(app)
    }

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}