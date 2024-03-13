package com.example.localstorage

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    lateinit var datos: EditText
    lateinit var bt_Guardar: Button
    lateinit var archivos: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        datos = findViewById(R.id.et_ToDoList)
        bt_Guardar = findViewById(R.id.bt_Guardar)
        archivos = fileList()
        try {
            leerArchivo()
        } catch (e : IOException ){

        }
    }

    @Throws(IOException::class)
    private fun leerArchivo() {
        lateinit var archivos: Array<String>
        archivos = fileList()
        if(existeArchivo(archivos, "tareas.txt")){
            var archivo : InputStreamReader = InputStreamReader((openFileInput("tareas.txt")))
            var miBuffer: BufferedReader = BufferedReader(archivo)
            var linea : String = miBuffer.readLine()
            var listaCompleta : String = ""
            while(linea != null){
                listaCompleta = listaCompleta + linea + "\n"
                linea = miBuffer.readLine()

            }
            miBuffer.close()
            archivo.close()
            datos.setText(listaCompleta)
        }
    }

    fun existeArchivo(archivos : Array<String>, nombre : String) : Boolean {
        for (archivo in archivos){
            if(nombre == archivo){
                return true
            }
        }
        return false;
    }

    fun guardar(vista : View) {
        try{
            var archivo : OutputStreamWriter = OutputStreamWriter(openFileOutput("tareas.txt", Activity.MODE_PRIVATE))
            archivo.write(datos.text.toString())
            archivo.flush()
            archivo.close()
            Toast.makeText(this, "Datos salvados!", Toast.LENGTH_SHORT).show()
        }catch (e : IOException){

        }
    }
}