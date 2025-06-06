package com.revan.aurora_project.domain.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Emotion(
    val name: String,
    val description: String,
    val imageResId: Int
) : Parcelable