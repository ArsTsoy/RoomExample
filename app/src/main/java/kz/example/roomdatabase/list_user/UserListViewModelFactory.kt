package kz.example.roomdatabase.list_user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.example.roomdatabase.FakeService
import javax.inject.Inject


class UserListViewModelFactory @Inject constructor(
    private val fakeService: FakeService
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(fakeService) as T
    }
}