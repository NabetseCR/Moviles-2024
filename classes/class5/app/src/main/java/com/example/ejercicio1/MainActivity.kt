package com.example.ejercicio1

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var etNombre: EditText
    lateinit var etNumero: EditText
    lateinit var btGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        etNumero = findViewById(R.id.etTel)
        btGuardar = findViewById(R.id.btnGuardar)

        var preferencesNames: SharedPreferences = getSharedPreferences("nombres", MODE_PRIVATE)
        var preferencesNumbers: SharedPreferences = getSharedPreferences("numeros", MODE_PRIVATE)
        //var valor: String = preferences.getString("correo","")?: ""

        fun clear(){
            etNumero.setText("")
            etNombre.setText("")
        }
    }
}