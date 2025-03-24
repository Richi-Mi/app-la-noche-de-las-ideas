package com.ipn.escom.lni.ui.model

import android.graphics.drawable.Drawable

data class IslaInfo(
    val name: String,
    val image: int,
    val events: List<EventInfo>,
    val direction: String //url de maps
)
