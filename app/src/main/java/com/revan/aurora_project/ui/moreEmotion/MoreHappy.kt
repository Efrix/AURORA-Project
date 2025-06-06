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

class MoreHappy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_happy)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionHappy=findViewById<ImageView>(R.id.imageViewEmotionHappy)
        val textViewEmotionNameHappy=findViewById<TextView>(R.id.textViewEmotionNameHappy)
        val  textViewEmotionDescHappy=findViewById<TextView>(R.id.textViewEmotionDescHappy)
        val emotion = intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameHappy.text = emotion?.name
        textViewEmotionDescHappy.text = emotion?.description
        imageViewEmotionHappy.setImageResource(emotion?.imageResId ?: R.drawable.logo)

    }
}