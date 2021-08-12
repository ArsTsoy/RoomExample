package kz.example.roomdatabase.create_user

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.example.roomdatabase.UserDAO
import kz.example.roomdatabase.model.User


class CreateUserViewModel(
    app: Application,
    private val userDao: UserDAO
): AndroidViewModel(app) {

    private val compositeDisposable = CompositeDisposable()

    fun createUser(
        user: User
    ) {
        val completableCreateUser = Completable
            .fromAction { userDao.createUser(user) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    Log.i("myCreateUserViewModel", "success create")
                },
                {
                    Log.i("myCreateUserViewModel", "error: $it")
                }
            )

        compositeDisposable.add(completableCreateUser)

    }


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}