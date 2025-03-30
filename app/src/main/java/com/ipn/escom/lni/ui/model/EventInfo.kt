package com.ipn.escom.lni.ui.model

import java.time.LocalTime

data class EventInfo (
    val name: String,
    val startHora: LocalTime,
    val finishHora: LocalTime,
    val description: String,
    val exponents: List<Speaker>?= null,
    val type: TipoEvento,
    val place: String,
    val direction: String
)