package com.example.sharedpreferences

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var etCorreo: EditText
    lateinit var btGuardar: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCorreo = findViewById(R.id.etEmail)
        btGuardar = findViewById(R.id.btGuardar)

        var preferences: SharedPreferences = getSharedPreferences("datos", MODE_PRIVATE)
        var valor: String = preferences.getString("correo","")?: ""
        etCorreo.setText(valor)

        btGuardar

    }
}