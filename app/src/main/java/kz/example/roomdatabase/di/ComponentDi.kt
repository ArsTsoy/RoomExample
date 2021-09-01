package kz.example.roomdatabase.di

import android.app.Application
import dagger.Component
import kz.example.roomdatabase.MyDatabase
import kz.example.roomdatabase.create_user.CreateUserViewModelFactory
import kz.example.roomdatabase.user_detail.UserDetailViewModel
import javax.inject.Singleton


@Component(modules = [DBModule::class])
@Singleton
interface ComponentDi {

    // 1 - ый способ
    fun getDB(): MyDatabase
    fun getApp(): Application


    fun getCreateUserVMFactory(): CreateUserViewModelFactory

    fun getAssistedFactory(): UserDetailViewModel.UserDetailViewModelAssistedFactory

}