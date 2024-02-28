package com.example.hello_world_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    // Defining variables
    lateinit var operando1: EditText
    lateinit var operando2: EditText
    lateinit var tvResultado: TextView
    lateinit var boton: Button
    lateinit var operation: RadioGroup
    lateinit var suma: RadioButton
    lateinit var resta: RadioButton
    lateinit var div: RadioButton
    lateinit var mult: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        operando1 = findViewById(R.id.operando1)
        operando2 = findViewById(R.id.operando2)
        tvResultado = findViewById(R.id.resultado)
        operation = findViewById(R.id.radioGroup)
        suma = findViewById(R.id.radio_suma)
        resta = findViewById(R.id.radio_resta)
        div = findViewById(R.id.radio_dividir)
        mult = findViewById(R.id.radio_multiplicar)

    }
    override fun onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }
    // logic goes here
    fun sumar(vista : View){
        var entero1: Int? = operando1.text.toString().toInt()
        var entero2: Int? = operando2.text.toString().toInt()
        var resultado: Int? = entero1!! + entero2!!
        var resString: String? = resultado.toString()
        val tv1: TextView = findViewById(R.id.resultado)
        tvResultado.text = resultado.toString()
    }

    fun calcular(vista: View){
        var entero1: Int = operando1.text.toString().toInt()
        var entero2: Int = operando2.text.toString().toInt()
        var resultado: Int? = 0
        if (suma.isChecked) {
            resultado = entero1 + entero2
        }
        if (resta.isChecked) {
            resultado = entero1 - entero2
        }
        if (mult.isChecked) {
            resultado = entero1 * entero2
        }
        if (div.isChecked) {
            resultado = entero1 / entero2
        }
        tvResultado.text = resultado.toString()
    }

    // listeners
}