package com.revan.aurora_project.ui.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.revan.aurora_project.R

class SingUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sing_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtName=findViewById<EditText>(R.id.SUName)
        val txtUser=findViewById<EditText>(R.id.SUUser)
        val txtMail=findViewById<EditText>(R.id.SUEmail)
        val txtAge=findViewById<EditText>(R.id.SUAge)
        val txtPass=findViewById<EditText>(R.id.SUPass)
        val txtConfPass=findViewById<EditText>(R.id.SUConfPass)
        val btnSinguP:Button=findViewById(R.id.btnNextSing)
        val spinner: Spinner = findViewById(R.id.SUGener)
        val items = listOf("Selecciona tu género", "Hombre", "Mujer", "Prefiero no decir")

        val adapter = object : ArrayAdapter<String>(this, R.layout.aurora_spinner_item, items) {

            override fun isEnabled(position: Int): Boolean {
                // Deshabilita la primera opción (hint)
                return position != 0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent) as TextView

                if (position == 0) {
                    // Hint en gris
                    view.setTextColor(Color.GRAY)
                }

                return view
            }
        }

        adapter.setDropDownViewResource(R.layout.aurora_dropdown)
        spinner.adapter = adapter
        spinner.setSelection(0) // Muestra el hint por defecto

        btnSinguP.setOnClickListener {
            val name = txtName.text.toString().trim()
        val user = txtUser.text.toString().trim()
        val email = txtMail.text.toString().trim()
        val ageText = txtAge.text.toString().trim()
        val pass = txtPass.text.toString()
        val confpass = txtConfPass.text.toString()
        val selectedPosition = spinner.selectedItemPosition
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@(gmail\\.com|hotmail\\.com|outlook\\.com)$")

        // Validar que ningún campo esté vacío
        if (name.isEmpty() || user.isEmpty() || email.isEmpty() || ageText.isEmpty() || pass.isEmpty() || confpass.isEmpty() || selectedPosition == 0) {
            Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        // Validar email
        if (!email.matches(emailRegex)) {
            Toast.makeText(this, "Correo inválido. Usa Gmail, Hotmail o Outlook", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        // Validar edad
        val ageNum = try {
            ageText.toShort()
        } catch (e: NumberFormatException) {
            -1 // valor inválido
        }

        if (ageNum <= 0 || ageNum > 100) {
            Toast.makeText(this, "Edad inválida. Debe ser entre 1 y 100", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        // Validar contraseñas
        if (pass != confpass) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return@setOnClickListener
        }

        // Si todo está bien:
        val selectedGender = spinner.selectedItem.toString()
        val intentLog = Intent(this, HomeActivity::class.java)
        intentLog.putExtra("userName", "$user")
        startActivity(intentLog)
        val sharedPreferences = getSharedPreferences("AuroraPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putBoolean("isLoggedIn", true)
        editor.putString("userName", user)   // aquí pones tu variable
        editor.putString("userEmail", email)  // y aquí el correo

        editor.apply()

    }

        val btnReturn: ImageView = findViewById(R.id.IMGreturn)
        btnReturn.setOnClickListener {
                onBackPressed()
        }



    }

}