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

class MoreSerious : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_serious)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionSerious=findViewById<ImageView>(R.id.imageViewEmotionSeroius)
        val textViewEmotionNameSerious=findViewById<TextView>(R.id.textViewEmotionNameSerious)
        val textViewEmotionDescSerious=findViewById<TextView>(R.id.textViewEmotionDescSerious)

        val emotion =intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameSerious.text = emotion?.name
        textViewEmotionDescSerious.text = emotion?.description
        imageViewEmotionSerious.setImageResource(emotion?.imageResId ?: R.drawable.logo)
    }
}