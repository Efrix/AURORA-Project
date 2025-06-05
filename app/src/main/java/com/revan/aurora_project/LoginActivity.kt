package com.revan.aurora_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtUser=findViewById<EditText>(R.id.LOUser)
        val txtMail=findViewById<EditText>(R.id.LOEmail)
        val txtPass=findViewById<EditText>(R.id.LOPass)
        val btnReturn: ImageView = findViewById(R.id.IMGreturn)
        btnReturn.setOnClickListener {
            onBackPressed()
        }
        val btnLogin : Button = findViewById(R.id.btnNextLogin)
        btnLogin.setOnClickListener {
            val user = txtUser.text.toString().trim()
            val email = txtMail.text.toString().trim()
            val pass = txtPass.text.toString()
            val emailRegex = Regex("^[A-Za-z0-9+_.-]+@(gmail\\.com|hotmail\\.com|outlook\\.com)$")

            // Validar que ningún campo esté vacío
            if ( user.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Por favor, rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validar email
            if (!email.matches(emailRegex)) {
                Toast.makeText(this, "Correo inválido. Usa Gmail, Hotmail o Outlook", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }




            // Si todo está bien:
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
    }
}