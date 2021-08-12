package kz.example.roomdatabase.di

import dagger.Component
import kz.example.roomdatabase.MyDatabase
import kz.example.roomdatabase.create_user.CreateUserViewModel
import javax.inject.Singleton


@Component(modules = [DBModule::class])
@Singleton
interface ComponentDi {

    // 1 - ый способ
    fun getDB(): MyDatabase

//
//
//    //2 - ой способ
    fun inject(createUserViewModel: CreateUserViewModel)


}