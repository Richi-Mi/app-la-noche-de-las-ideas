package com.ipn.escom.lni.ui.model

import android.graphics.drawable.Drawable

data class IslaInfo(
    val name: String,
    val image: Int,
    val events: List<EventInfo>,
    val description: String?= null
)
