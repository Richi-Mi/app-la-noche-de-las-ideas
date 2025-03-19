package com.ipn.escom.lni.ui.model

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.ipn.escom.lni.R

enum class TipoEvento(
    @StringRes val value: Int
) {
    CONFERENCIA( R.string.app_eventType_conference ),
    TALLER(R.string.app_eventType_taller ),
    MESA_REDONDA(R.string.app_eventType_mesa_redonda ),
    EXPOSICION(R.string.app_eventType_exposición),
    PELICULA(R.string.app_evenType_pelicula)
}