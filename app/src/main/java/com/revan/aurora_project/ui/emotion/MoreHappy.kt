package com.revan.aurora_project.ui.emotion

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
        val imageViewEmotion=findViewById<ImageView>(R.id.imageViewEmotion)
        val textViewEmotionName=findViewById<TextView>(R.id.textViewEmotionName)
        val  textViewEmotionDesc=findViewById<TextView>(R.id.textViewEmotionDesc)
        val emotion = intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionName.text = emotion?.name
        textViewEmotionDesc.text = emotion?.description
        imageViewEmotion.setImageResource(emotion?.imageResId ?: R.drawable.logo)

    }
}