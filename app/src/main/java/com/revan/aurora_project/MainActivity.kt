package com.revan.aurora_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.revan.aurora_project.ui.home.HomeActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔍 Verificar si ya hay sesión activa
        val sharedPreferences = getSharedPreferences("AuroraPrefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
            return // salimos del método para no seguir cargando MainActivity
        }

        // ⚙️ Si no hay sesión activa, se muestra la pantalla con los botones
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSingUp: Button = findViewById(R.id.btnSingUp)
        btnSingUp.setOnClickListener {
            val intent = Intent(applicationContext, SingUpActivity::class.java)
            startActivity(intent)
        }

        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent2 = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent2)
        }

        val btnExit: ImageView = findViewById(R.id.IMGExit)
        btnExit.setOnClickListener {
            exitProcess(0)
        }
    }
}
