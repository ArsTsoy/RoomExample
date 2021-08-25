package kz.example.roomdatabase.create_user

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.example.roomdatabase.MyDatabase
import javax.inject.Inject

class CreateUserViewModelFactory @Inject constructor(
    private val app: Application,
    private val db: MyDatabase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreateUserViewModel(
            app,
            db
        ) as T
    }
}