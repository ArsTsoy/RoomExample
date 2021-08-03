package kz.example.roomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val USER_TABLE_NAME = "USER"

@Entity(tableName = USER_TABLE_NAME)
class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "user_name")
    var name: String,

    var lastName: String,

    var age: Int,

    var comment: String
)