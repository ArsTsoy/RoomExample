package kz.example.roomdatabase.list_user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kz.example.roomdatabase.FakeService
import kz.example.roomdatabase.model.User


class UserListViewModel(
    private val fakeService: FakeService
): ViewModel() {

    private val users: MutableLiveData<List<User>> = MutableLiveData()
    fun observeUsers(): LiveData<List<User>> = users

    private val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    fun observeIsLoading(): LiveData<Boolean> = isLoading

    private val listUsers: MutableList<User> = mutableListOf()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            isLoading.postValue(true)
            fakeService.getUsers()
                .collect {
                    listUsers.add(it)
                    users.postValue(listUsers)
                }
            isLoading.postValue(false)
        }
    }

}