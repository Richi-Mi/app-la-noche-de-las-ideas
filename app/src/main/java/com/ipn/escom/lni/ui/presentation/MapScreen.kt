package com.ipn.escom.lni.ui.presentation

import android.graphics.drawable.VectorDrawable
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ipn.escom.lni.NavRoutes
import com.ipn.escom.lni.R
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun ScrollableMap(
    navHostController: NavController,
    innerPaddingValues: PaddingValues
) {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.mapa) // Reemplaza con tu mapa


    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember   { mutableFloatStateOf(1f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(innerPaddingValues)
            .clickable {
                navHostController.navigate( NavRoutes.getDetailRoute(3) )
            }
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

            val pivot = Offset((canvasWidth / 2) - (imageWidth / 2), (canvasHeight / 2) - imageHeight)

            translate(left = offsetX, top = offsetY) {
                scale(scale * initialScale, pivot = pivot) {
                    drawImage(imageBitmap)
                }
            }
        }
    }
}
