package kz.example.roomdatabase.user_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kz.example.roomdatabase.MyDatabase


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


    class UserDetailViewModelFactory @AssistedInject constructor(
        private val db: MyDatabase,
        @Assisted("userId") private val userId: Int
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return UserDetailViewModel(
                db, userId
            ) as T
        }

        @AssistedFactory
        interface Factory {
            fun create(@Assisted("userId") userId: Int): UserDetailViewModelFactory
        }

    }
}

