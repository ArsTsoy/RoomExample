package kz.example.roomdatabase

import android.app.Application
import kz.example.roomdatabase.di.ComponentDi
import kz.example.roomdatabase.di.DBModule

import kz.example.roomdatabase.di.DaggerComponentDi


class App: Application() {

    val componentDI: ComponentDi = DaggerComponentDi.builder()
        .dBModule(DBModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()


    }
}