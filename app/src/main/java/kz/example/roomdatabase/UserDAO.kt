package kz.example.roomdatabase

import androidx.room.*
import kz.example.roomdatabase.model.USER_TABLE_NAME
import kz.example.roomdatabase.model.User


@Dao
abstract class UserDAO {

    @Insert
    abstract fun createUser(user: User)

    @Delete
    abstract fun deleteUser(user: User)

    @Update
    abstract fun updateUser(user: User)

    @Query("SELECT * FROM $USER_TABLE_NAME")
    abstract fun getAllUsers(): List<User>

    @Query("SELECT * FROM $USER_TABLE_NAME WHERE id = :id")
    abstract fun getUser(id: Int): User
}