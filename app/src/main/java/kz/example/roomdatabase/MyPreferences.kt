package kz.example.roomdatabase

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

object MyPreferences {
    private var preferences: SharedPreferences? = null

    fun getPreferences(app: Application): SharedPreferences {
        if (preferences == null) {
            preferences = app.getSharedPreferences("MY_PREFERENCES", Context.MODE_PRIVATE)
        }
        return preferences!!
    }


    const val INPUTTED_USER_NAME = "INPUTTED_USER_NAME"
}