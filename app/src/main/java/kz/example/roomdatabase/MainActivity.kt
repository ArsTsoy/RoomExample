package kz.example.roomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.example.roomdatabase.create_user.CreateUserFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = CreateUserFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment)
            .commit()

//        val btnSave = findViewById<Button>(R.id.btnSave)
//        val btnGet = findViewById<Button>(R.id.btnGet)
//        val etText = findViewById<EditText>(R.id.etText)
//
//
//        btnSave.setOnClickListener {
//            saveText(etText.text.toString())
//        }
//
//        btnGet.setOnClickListener {
//            etText.setText(getSavedTextIfExist())
//        }

    }

//    private fun saveText(text: String) {
//        MyPreferences.getPreferences(application)
//            .edit()
//            .putString(MyPreferences.INPUTTED_USER_NAME, text)
//            .apply()
//    }
//
//    private fun getSavedTextIfExist(): String {
//        return MyPreferences.getPreferences(application)
//            .getString(MyPreferences.INPUTTED_USER_NAME, "") ?: ""
//    }


}