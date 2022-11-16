package com.example.demoproject

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var name:TextView
    lateinit var age:TextView
    lateinit var save:Button
    lateinit var load:Button

    lateinit var sharedPreferences: SharedPreferences

    var userName:String?=null
    var userAge:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.editTextTextName)
        age = findViewById(R.id.editTextNumber)
        save = findViewById(R.id.saveButton)
        load = findViewById(R.id.loadButton)

        save.setOnClickListener {
            saveData()
        }

    }
    override fun onResume() {
        super.onResume()

        load.setOnClickListener {
            loadData()
        }

    }

    /*override fun onPause() {
        super.onPause()

        save.setOnClickListener {
            saveData()
        }

    } */


    fun saveData()
    {
        sharedPreferences=this.getSharedPreferences("saveData",Context.MODE_PRIVATE)

        userName = name.text.toString()
        userAge = age.text.toString().toInt()

        var editor = sharedPreferences.edit()

        editor.putString("name",userName)
        editor.putInt("age", userAge!!)

        editor.apply()
    }

    fun loadData()
    {
        sharedPreferences=this.getSharedPreferences("saveData",Context.MODE_PRIVATE)

        userName = sharedPreferences.getString("name",null)
        userAge = sharedPreferences.getInt("age",0)


        name.setText(userName)
        age.setText(""+userAge)

    }


    /*override fun onResume() {
        super.onResume()

        load.setOnClickListener {
            loadData()
        }

    }*/

}