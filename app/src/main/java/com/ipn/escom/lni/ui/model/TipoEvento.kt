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
    PELICULA(R.string.app_evenType_pelicula),
    DOCUMENTAL(R.string.app_evenType_documental),
    COMIDA(R.string.app_evenType_comida),
    MESA_DIALOGO(R.string.app_evenType_mesa_dialogo),
    ACTIVIDAD_LUDICA(R.string.app_evenType_actividad),
    SKETCH(R.string.app_evenType_sketch),
    ACTO_MUSICAL(R.string.app_evenType_acto_musical),
    CONVERSATORIO(R.string.app_eventType_conversatorio),
    EXHIBICION_ARTE(R.string.app_eventType_exhibicion_arte),
    VIDEOCONFERENCIA(R.string.app_eventType_video_conferencia),
    INAGURACION(R.string.app_eventType_inaguracion),
    GRABACION(R.string.app_eventType_grabacion)
}