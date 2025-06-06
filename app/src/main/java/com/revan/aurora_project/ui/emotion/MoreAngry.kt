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
import org.w3c.dom.Text

class MoreAngry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_more_angry)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageViewEmotionAngry=findViewById<ImageView>(R.id.imageViewEmotionAngry)
        val textViewEmotionNameAngry=findViewById<TextView>(R.id.textViewEmotionNameAngry)
        val textViewEmotionDescAngry=findViewById<TextView>(R.id.textViewEmotionDescAngry)

        val emotion =intent.getParcelableExtra<Emotion>("emotion")
        textViewEmotionNameAngry.text = emotion?.name
        textViewEmotionDescAngry.text = emotion?.description
        imageViewEmotionAngry.setImageResource(emotion?.imageResId ?: R.drawable.logo)
    }
}