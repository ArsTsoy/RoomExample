package kz.example.roomdatabase

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kz.example.roomdatabase.model.User

const val MY_DATABASE_NAME = "MY_DATABASE_NAME"

@Database(entities = arrayOf(User::class), version = 1)
abstract class MyDatabase: RoomDatabase()  {

    companion object {
        private var instance: MyDatabase? = null

        fun getInstance(app: Application): MyDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(
                    app.applicationContext,
                    MyDatabase::class.java,
                    MY_DATABASE_NAME
                ).build()
            }
            return instance!!
        }
    }

    abstract fun getUserDao(): UserDAO
}