package kz.example.roomdatabase.create_user

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.example.roomdatabase.UserDAO


class CreateUserViewModelFactory(
    private val app: Application,
    private val userDAO: UserDAO
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateUserViewModel(
            app, userDAO
        ) as T
    }
}