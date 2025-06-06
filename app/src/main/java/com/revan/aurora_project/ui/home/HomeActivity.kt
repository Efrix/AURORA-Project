package com.revan.aurora_project.ui.home

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.revan.aurora_project.ui.fragments.HomeFragment
import com.revan.aurora_project.ui.fragments.ProfileFragment
import com.revan.aurora_project.R
import com.revan.aurora_project.ui.fragments.SearchFragment

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        // Fragment inicial
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.nav_home -> HomeFragment()
                R.id.nav_search -> SearchFragment()
                R.id.nav_profile -> ProfileFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, it)
                    .commit()
                true
            } ?: false
        }
        val HomeUser = findViewById<TextView>(R.id.txtHomeUser)
        // Si por alguna razón viene nulo, asignamos cadena vacía
        val userHome = intent.getStringExtra("userName") ?: ""
        HomeUser.text = "¡Hola $userHome!"
    }
}
