package com.revan.aurora_project.ui.moreEmotion

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.revan.aurora_project.R
import com.revan.aurora_project.domain.model.Emotion

class MoreSadness : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_sadness)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionSad=findViewById<ImageView>(R.id.imageViewEmotionSad)
        val textViewEmotionNameSad=findViewById<TextView>(R.id.textViewEmotionNameSad)
        val textViewEmotionDescSad=findViewById<TextView>(R.id.textViewEmotionDescSad)

        val emotion =intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameSad.text = emotion?.name
        textViewEmotionDescSad.text = emotion?.description
        imageViewEmotionSad.setImageResource(emotion?.imageResId ?: R.drawable.logo)
    }
}