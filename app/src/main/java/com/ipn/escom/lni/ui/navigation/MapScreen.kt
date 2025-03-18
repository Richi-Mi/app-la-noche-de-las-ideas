package com.ipn.escom.lni.ui.navigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.ipn.escom.lni.R
import kotlin.math.max
import kotlin.math.min

@Composable
fun ScrollableMap() {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.mapa)

    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    var scale   by remember { mutableStateOf(1f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    offsetX += pan.x
                    offsetY += pan.y
                    scale = max(1f, min(scale * zoom, 3f)) // Zoom entre 1x y 3x
                }
            }
    ) {
        /*
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val centerX = size.width / 2
            val centerY = size.height / 2

            translate(left = offsetX, top = offsetY) { // Mueve la imagen según el desplazamiento
                scale(scale, pivot = Offset(centerX, centerY)) { // Aplica el zoom manteniendo el centro
                    drawImage(imageBitmap) // Dibuja la imagen del mapa
                }
            }
        } */
    }
}

@Preview
@Composable
fun PreviewScrollableMap() {
    ScrollableMap()
}
