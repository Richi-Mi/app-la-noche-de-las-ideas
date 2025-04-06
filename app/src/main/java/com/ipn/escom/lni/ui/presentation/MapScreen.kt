package com.ipn.escom.lni.ui.presentation


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.ipn.escom.lni.NavRoutes
import com.ipn.escom.lni.R
import com.ipn.escom.lni.islasGlobal
import com.ipn.escom.lni.ui.model.IslaInfo
import kotlin.math.max
import kotlin.math.min

@Composable
fun ScrollableMap(
    navHostController: NavController,
    innerPaddingValues: PaddingValues
) {
    val imageBitmap = ImageBitmap.imageResource(id = R.drawable.mapa) // Reemplaza con tu mapa
    var showDialog by remember { mutableStateOf(false) }

    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }
    var scale by remember   { mutableFloatStateOf(1f) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(innerPaddingValues)
    ) {
        AnimatedStarsBackground()

        Canvas(
            modifier = Modifier.fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures{  _,pan, zoom, _ ->
                        offsetX += pan.x
                        offsetY += pan.y
                        scale = max(0.7f, min(scale*zoom, 2.5f))
                    }
                }
                .clickable { showDialog=true }
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
        if (showDialog){
            DialogUtopia(
                onDismiss = { showDialog = false },
                onViewClick = {
                    showDialog = false
                    navHostController.navigate( NavRoutes.getDetailRoute(3) )
                },
                islasGlobal[3]
            )
        }
    }
}

@Composable
fun DialogUtopia(
    onDismiss: () -> Unit,
    onViewClick: () -> Unit,
    isla: IslaInfo
) {
    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .padding(24.dp)
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Text(
                        text = isla.name,
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Clear, contentDescription = "Cerrar")
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Image(
                    painter = painterResource( id = isla.image),
                    contentDescription = "Imagen de isla",
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .clip(RoundedCornerShape(24.dp)),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = isla.description ?: "",
                    modifier = Modifier.padding(top = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onViewClick,
                    colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.tertiaryContainer)
                ) {
                    Text("Ver", color = MaterialTheme.colorScheme.onTertiary)
                }
            }
        }
    }
}
