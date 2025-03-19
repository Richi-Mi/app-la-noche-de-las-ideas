package com.ipn.escom.lni.ui.model

import java.time.LocalTime

data class EventInfo (
    val name: String,
    val hora: LocalTime,
    val description: String,
    val exponents: List<Speaker>,
    val type: TipoEvento
)