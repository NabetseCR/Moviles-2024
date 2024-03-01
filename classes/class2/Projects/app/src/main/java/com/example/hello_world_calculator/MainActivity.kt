package com.example.hello_world_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
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
        boton = findViewById(R.id.suma)

        //Adding listeners
        operando1.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                validateField(operando1)
                return@setOnEditorActionListener false
            }
            false
        }
        operando2.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                validateField2(operando2)
                return@setOnEditorActionListener false
            }
            false
        }
    }

    private fun validateField(operando: EditText) {
        val name = operando.text.toString().trim()
        if (TextUtils.isEmpty(name)) {
            boton.isEnabled = false
            boton.isClickable = false
            operando.error = "Valor es requerido"
        } else {
            boton.isEnabled = true
            boton.isClickable = true
            // Name is not empty, perform further actions
        }
    }

    private fun validateField2(operando: EditText) {
        val name = operando.text.toString().trim()
        if (TextUtils.isEmpty(name)) {
            boton.isEnabled = false
            boton.isClickable = false
            operando.error = "Valor es requerido"
        } else if(name.equals("0") && div.isChecked){
            boton.isEnabled = false
            boton.isClickable = false
            operando.error = "Division entre 0 no es valida"
        } else {
            boton.isEnabled = true
            boton.isClickable = true
            // Name is not empty, perform further actions
        }
    }
    /*fun setFocusChangeListener(editText: EditText){
        editText.setOnFocusChangeListener { v, hasFocus ->

        }
        editText.setOnFocusChangeListener{ v, hasFocus ->
            if(!hasFocus){
                if(!noVacio(editText)){
                    editText.error = "Debe indicar un valor"
                }
            }
        }
    }

     fun noVacio(text: EditText): Boolean {
        return text.text.toString().isEmpty()
    }*/

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