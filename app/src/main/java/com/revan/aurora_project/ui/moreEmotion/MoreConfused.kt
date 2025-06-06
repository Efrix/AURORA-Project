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

class MoreConfused : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_confused)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionConfused=findViewById<ImageView>(R.id.imageViewEmotionConfused)
        val textViewEmotionNameConfused=findViewById<TextView>(R.id.textViewEmotionNameConfused)
        val textViewEmotionDescConfused=findViewById<TextView>(R.id.textViewEmotionDescConfused)

        val emotion =intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameConfused.text = emotion?.name
        textViewEmotionDescConfused.text = emotion?.description
        imageViewEmotionConfused.setImageResource(emotion?.imageResId ?: R.drawable.logo)
    }
}