package com.ipn.escom.lni.ui.navigation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.imageResource
import androidx.navigation.NavHostController
import com.ipn.escom.lni.R
import kotlin.math.max
import kotlin.math.min

@Composable
fun ScrollableMap(
    navHostController: NavHostController,
    innerPaddingValues: PaddingValues
) {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.mapa) // Reemplaza con tu mapa

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember   { mutableFloatStateOf(1f) }

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
            .background( Color.Transparent )
            .padding( innerPaddingValues )
    ) {
        AnimatedStarsBackground()

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val imageWidth = imageBitmap.width.toFloat()
            val imageHeight = imageBitmap.height.toFloat()

            // Escala inicial para que la imagen llene la pantalla sin deformarse
            val scaleX = canvasWidth / imageWidth
            val scaleY = canvasHeight / imageHeight
            val initialScale = max(scaleX, scaleY) // Mantener la proporción sin deformar

            val pivot = Offset( (canvasWidth / 2)-(imageWidth / 2), (canvasHeight / 2)-(imageHeight) )

            translate(left = offsetX, top = offsetY) {
                scale(scale * initialScale, pivot = pivot) {
                    drawImage(imageBitmap)
                    drawCircle(
                        radius = 15f * scale,
                        center = Offset(imageWidth / 16,10f),
                        color = Color.Red
                    )
                }
            }


        }
    }
}
