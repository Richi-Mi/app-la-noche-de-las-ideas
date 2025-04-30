package com.ipn.escom.lni.ui.presentation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.ipn.escom.lni.R
import com.ipn.escom.lni.mediaPlayer
import com.ipn.escom.lni.volume
import kotlin.random.Random

@Composable
fun StyledButton(onClick: () -> Unit, text: String) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.6f)
            .clip(RoundedCornerShape(24.dp)) // Bordes redondeados
            .border(2.dp, Color.White, RoundedCornerShape(24.dp)), // Borde decorativo
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Fondo transparente para respetar el fondo manual
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.White, // Color oscuro del texto
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )
    }
}

@Composable
fun AnimatedStarsBackground() {
    val stars = remember { generateStars(100) } // Generar 100 estrellas al inicio

    // Animación infinita de parpadeo
    val infiniteTransition = rememberInfiniteTransition()
    val alphaList = stars.map {
        infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = Random.nextInt(1000, 3000), easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        stars.forEachIndexed { index, star ->
            drawCircle(
                color = Color.White.copy(alpha = alphaList[index].value),
                radius = star.radius,
                center = Offset(star.x, star.y)
            )
        }
    }
}

// Datos de las estrellas
data class Star(val x: Float, val y: Float, val radius: Float)

// Genera estrellas con posiciones aleatorias
fun generateStars(count: Int): List<Star> {
    return List(count) {
        Star(
            x = Random.nextFloat() * 1080f,  // Ajustar según resolución
            y = Random.nextFloat() * 1920f,
            radius = Random.nextFloat() * 4f + 2f // Radio aleatorio entre 2 y 5
        )
    }
}

@Composable
fun HomeScreen( innerPadding: PaddingValues, onClick: () -> Unit ) {
    val offset = Offset(5.0f, 10.0f)
    var about by remember { mutableStateOf(false) }
    var volumeImage by remember { mutableIntStateOf(
        when (volume) {
            0.5f -> R.drawable.volume_low_solid
            0.0f -> R.drawable.volume_off_solid
            1.0f -> R.drawable.volume_high_solid
            else -> R.drawable.volume_high_solid
        }
    ) }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFF10131A))
            .padding( innerPadding )
    ) {

        Dialog(
            onDismissRequest = { about = false }
        ) {
            Text(text = "Aplicación creada por: ")
            Text("EQUIPO 99% fe")
            Text("Mendoza Castañeda José Ricardo")
            Text("Rodriguez Mendoza Christopher")
            Text("Peredo Borgonio Daniel")
        }

        AnimatedStarsBackground()

        Row( modifier = Modifier.align(Alignment.TopEnd)) {
            Icon(
                painter = painterResource(id = volumeImage),
                contentDescription = "Volumen",
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clickable {
                        when (volume) {
                            1.0f -> {
                                volume = 0.5f
                                volumeImage = R.drawable.volume_low_solid
                            }
                            0.5f -> {
                                volume = 0.0f
                                volumeImage = R.drawable.volume_off_solid
                            }
                            0.0f -> {
                                volume = 1.0f
                                volumeImage = R.drawable.volume_high_solid
                            }
                        }
                        mediaPlayer.setVolume(volume, volume)
                    },
                tint = Color.White
            )
            Spacer(Modifier.width(16.dp))
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Acerca De",
                modifier = Modifier
                    .size(50.dp)
                    .padding(8.dp)
                    .clickable {
                        about = true
                    },
                tint = Color.White
            )

        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier.height(150.dp).fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.app_name),
                color = Color.White,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.displayMedium.fontSize,
                    shadow = Shadow(
                        color = Color.Gray, offset = offset, blurRadius = 3f
                    )
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            StyledButton( onClick = { onClick() }, text = stringResource( R.string.app_entry ) )
        }
    }
}
