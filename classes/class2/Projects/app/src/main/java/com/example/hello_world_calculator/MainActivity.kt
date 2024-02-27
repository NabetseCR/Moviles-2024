package com.example.hello_world_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val materia1: Int = 7;
        val materia2: Int = 7;
        val materia3: Int = 7;
        val promedio: Int = (materia1 + materia2 + materia3) / 3;
        if(promedio >= 6){
            Toast.makeText(this,"Aprobado", Toast.LENGTH_LONG).show();
        }else if(promedio <= 6){
            Toast.makeText(this,"Reprobado", Toast.LENGTH_LONG).show();
        }
    }
    override fun onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }
    // logic goes here

}