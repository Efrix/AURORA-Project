package com.revan.aurora_project

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.json.JSONObject
import java.io.BufferedReader

class HappyEmotion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_happy_emotion2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnAnalizar = findViewById<Button>(R.id.btnAnalizarEmocion)
        val editText = findViewById<EditText>(R.id.editTextEmotion)
        val charCount = findViewById<TextView>(R.id.charCountText)

        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                charCount.text = "${s?.length ?: 0} / 250"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


// Contador de caracteres
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                charCount.text = "${s?.length ?: 0} / 250"
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        fun cargarPalabrasClave(context: Context): Map<String, List<String>> {
            val inputStream = context.assets.open("palabras_clave.json")
            val jsonString = inputStream.bufferedReader().use(BufferedReader::readText)
            val jsonObject = JSONObject(jsonString)

            val emocionesMap = mutableMapOf<String, List<String>>()
            jsonObject.keys().forEach { emocion ->
                val palabras = jsonObject.getJSONArray(emocion)
                val listaPalabras = mutableListOf<String>()
                for (i in 0 until palabras.length()) {
                    listaPalabras.add(palabras.getString(i))
                }
                emocionesMap[emocion] = listaPalabras
            }

            return emocionesMap
        }
        fun detectarEmocionDesdeJson(texto: String, emocionesMap: Map<String, List<String>>): String {
            val t = texto.lowercase()

            for ((emocion, palabras) in emocionesMap) {
                if (palabras.any { t.contains(it) }) {
                    return emocion
                }
            }

            return "No se detectó una emoción clara"
        }
// Evento del botón
        val emocionesMap = cargarPalabrasClave(this)

        btnAnalizar.setOnClickListener {
            val texto = editText.text.toString()
            val emocion = detectarEmocionDesdeJson(texto, emocionesMap)
            when (emocion) {
                "Feliz" -> startActivity(Intent(this, MoreHappy::class.java))

                else -> Toast.makeText(this, "Creo que no estás feliz, intenta con otra emoción 😕", Toast.LENGTH_SHORT)
                    .show()
            }
print("Hello world")

        }
    }
}