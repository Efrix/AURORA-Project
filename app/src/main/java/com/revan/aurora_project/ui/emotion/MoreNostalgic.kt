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

class MoreNostalgic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_nostalgic)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionNostalgic=findViewById<ImageView>(R.id.imageViewEmotionNostalgic)
        val textViewEmotionNameNostalgic=findViewById<TextView>(R.id.textViewEmotionNameNostagic)
        val textViewEmotionDescNostalgic=findViewById<TextView>(R.id.textViewEmotionDescNostalgic)

        val emotion =intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameNostalgic.text = emotion?.name
        textViewEmotionDescNostalgic.text = emotion?.description
        imageViewEmotionNostalgic.setImageResource(emotion?.imageResId ?: R.drawable.logo)
    }
}