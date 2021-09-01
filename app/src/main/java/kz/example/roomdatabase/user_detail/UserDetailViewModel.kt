package kz.example.roomdatabase.user_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.example.roomdatabase.MyDatabase
import javax.inject.Inject


class UserDetailViewModel(
    private val db: MyDatabase,
    private val userId: Int
) : ViewModel() {

    //region LiveData
    private val userIdLV: MutableLiveData< Int> = MutableLiveData()
    fun observerUserIdLV(): LiveData<Int> = userIdLV
    //endregion

    fun onBtnClicked() {
        userIdLV.postValue(userId)
    }


    class UserDetailViewModelFactory(
        private val db: MyDatabase,
        private val userId: Int
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return UserDetailViewModel(
                db, userId
            ) as T
        }
    }

    class UserDetailViewModelAssistedFactory @Inject constructor(
        private val db: MyDatabase
    ) {
        fun create(userId: Int): UserDetailViewModelFactory {
            return UserDetailViewModelFactory(db, userId)
        }
    }
}
