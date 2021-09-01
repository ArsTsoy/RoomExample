package kz.example.roomdatabase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kz.example.roomdatabase.model.User
import javax.inject.Inject


class FakeService @Inject constructor(
    private val db: MyDatabase
) {

    suspend fun getUsers(): Flow<User> {
        return flow {
            val users = db.getUserDao().getAllUsers()
            for (user in users) {
                kotlinx.coroutines.delay(3_000)
                emit(user)
            }

        }
    }
}