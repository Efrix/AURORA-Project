package com.revan.aurora_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.revan.aurora_project.ui.emotion.HappyEmotion

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
       val txtPrueba=view.findViewById<TextView>(R.id.txtMuestra)
        txtPrueba.text="¿Que tal, como te sientes hoy?"

        val btnHappy= view.findViewById<Button>(R.id.btnHappy)
        btnHappy.setOnClickListener {
    val feliEmo=Intent(requireContext(), HappyEmotion::class.java)
            startActivity(feliEmo)
        }
        val btnSadness=view.findViewById<Button>(R.id.btnSadness)
        btnSadness.setOnClickListener {
            val sadEmo=Intent(requireContext(),SadnessEmotion::class.java)
            startActivity(sadEmo)
        }
        val btnAngry=view.findViewById<Button>(R.id.btnAngry)
        btnAngry.setOnClickListener {
            val angEmo=Intent(requireContext(),AngryEmotion::class.java)
            startActivity(angEmo)
        }
        val btnSerious=view.findViewById<Button>(R.id.btnSerious)
        btnSerious.setOnClickListener {
            val serEmo=Intent(requireContext(),SeriousEmotion::class.java)
            startActivity(serEmo)
        }
        val btnNostalgic=view.findViewById<Button>(R.id.btnNostalgic)
        btnNostalgic.setOnClickListener {
            val nosEmo=Intent(requireContext(),NostalgicEmotion::class.java)
            startActivity(nosEmo)
        }
        val btnConfused=view.findViewById<Button>(R.id.btnConfused)
        btnConfused.setOnClickListener {
            val conEmo=Intent(requireContext(),ConfusedEmotion::class.java)
            startActivity(conEmo)
        }


    }
}