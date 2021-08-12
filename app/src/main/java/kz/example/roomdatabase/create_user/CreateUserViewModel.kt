package kz.example.roomdatabase.create_user

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kz.example.roomdatabase.App
import kz.example.roomdatabase.MyDatabase
import kz.example.roomdatabase.model.User
import javax.inject.Inject


class CreateUserViewModel(
    app: Application
): AndroidViewModel(app) {

    init{
        (app as App).componentDI.inject(this)
    }

    //region DI
    @Inject
    internal lateinit var db: MyDatabase
    //endregion

    private val compositeDisposable = CompositeDisposable()

    fun createUser(
        user: User
    ) {
        val completableCreateUser = Completable
            .fromAction { db.getUserDao().createUser(user) }
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