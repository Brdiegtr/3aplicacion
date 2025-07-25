package com.example.a3aplicacion

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri

class MainActivity : AppCompatActivity() {

    private lateinit var formLayout: LinearLayout
    private lateinit var datosLayout: LinearLayout
    private lateinit var edtNombre: EditText
    private lateinit var edtEdad: EditText
    private lateinit var txtDatos: TextView
    private lateinit var btnEnviar: Button
    private lateinit var btnVolver: Button
    private lateinit var btnGoogle: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        formLayout = findViewById(R.id.formLayout)
        datosLayout = findViewById(R.id.datosLayout)
        edtNombre = findViewById(R.id.edtNombre)
        edtEdad = findViewById(R.id.edtEdad)
        txtDatos = findViewById(R.id.txtDatos)
        btnEnviar = findViewById(R.id.btnEnviar)
        btnVolver = findViewById(R.id.btnVolver)
        btnGoogle = findViewById(R.id.btnGoogle)

        btnEnviar.setOnClickListener {
            val nombre = edtNombre.text.toString().trim()
            val edad = edtEdad.text.toString().trim()

            if (nombre.isEmpty() || edad.isEmpty()) {
                Toast.makeText(this, "Completa ambos campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            txtDatos.text = "Nombre: $nombre\nEdad: $edad"

            formLayout.visibility = LinearLayout.GONE
            datosLayout.visibility = LinearLayout.VISIBLE
        }

        btnVolver.setOnClickListener {
            // Limpia campos y muestra formulario
            edtNombre.text.clear()
            edtEdad.text.clear()

            datosLayout.visibility = LinearLayout.GONE
            formLayout.visibility = LinearLayout.VISIBLE
        }
        btnGoogle.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(intent)
        }
    }
}
