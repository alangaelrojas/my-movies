package com.alangaelrojas.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Este metodo es parte de android.app.Activity y nos permite cargar el
         * xml que se pasa como parametro en el activity correspondinete donde se manda llamar
         **/
        setContentView(R.layout.activity_main)


        Toast.makeText(this, "Creado", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "Iniciado", Toast.LENGTH_SHORT).show()

        val edtCorreo = findViewById<EditText>(R.id.edtCorreo)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)


        btnLogin.setOnClickListener {
            /** aqui se escucha cuando se da un click en un elemento
             * lo que permite en este ejemplo que cuando presionemos sobre btnLogin, tomar el valor
             * de edtCorreo y mostrarlo en un Toast
             */

            val correo = edtCorreo.text.toString()
            Toast.makeText(this, correo, Toast.LENGTH_LONG).show()
        }

    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "Detenida", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(application, "Destruida", Toast.LENGTH_SHORT).show()
    }


}