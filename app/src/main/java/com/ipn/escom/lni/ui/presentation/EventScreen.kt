package com.ipn.escom.lni.ui.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.VideoSize
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.ipn.escom.lni.mediaPlayer
import com.ipn.escom.lni.pause
import com.ipn.escom.lni.ui.model.EventInfo
import com.ipn.escom.lni.ui.model.Speaker

@Composable
fun EventScreen(event: EventInfo) {
    val context = LocalContext.current
    val nombreEvento = stringResource(id = event.type.value)
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF10131A))
        .padding(16.dp)){
        AnimatedStarsBackground()
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            Column (Modifier.fillMaxWidth()){
                Text(
                    text = event.name,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                EventDetailRow(Icons.Default.Star, "Hora", event.startHora.toString() +" PM - " + event.finishHora.toString() + " PM")
                EventDetailRow(Icons.Default.Place, "Lugar", event.place)
                EventDetailRow(Icons.Default.Info, "Tipo de evento", nombreEvento)
                if(event.description != "")
                    EventDetailRow(Icons.Default.Check, "Descripción", event.description)
                if(event.exponents != null) {
                    event.exponents.forEach { speaker: Speaker ->
                        ExponentsDetails(speaker, context)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(48.dp))
            }
        }

        FloatingActionButton(
            onClick = {
                abrirNavegador(context, event.direction)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(15.dp)
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = "Ubicación", tint = Color.Red)
        }
    }

}

@Composable
fun EventDetailRow(icon: ImageVector, title: String, content: String){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(
                MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(20.dp)
            )
    )
    {
        Icon(icon, title, tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 8.dp))

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = content,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExponentsDetails (exponent: Speaker, context: Context) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(20.dp))
    )
    {
        Box(modifier = Modifier.fillMaxWidth( )) {
            Image(
                painter = painterResource(id = exponent.image),
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .width(150.dp)
                    .align(alignment = Alignment.TopCenter),
                contentScale = ContentScale.Fit,
                contentDescription = exponent.name
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = exponent.name,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = exponent.biography,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        if(exponent.video != null){
            VideoPlayer(
                context = context,
                videoUri = "android.resource://${context.packageName}/raw/${exponent.video}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

fun abrirNavegador (context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}
/*
@Composable
fun VideoPlayer(context: Context, videoUri: String, modifier: Modifier){
    var videoAspectRatio by remember { mutableFloatStateOf(16 / 9f) }

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = false
            addListener(object : Player.Listener {
                override fun onVideoSizeChanged(videoSize: VideoSize) {
                    //Se obtiene el tamaño real del video
                    videoAspectRatio = if(videoSize.height != 0)
                        videoSize.width.toFloat() / videoSize.height
                    else
                        16/9f
                }
            })
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }



    AndroidView(factory = {
        PlayerView(context).apply {
            player = exoPlayer
            useController = true
        }
    }, modifier = modifier.aspectRatio(videoAspectRatio))
}
*/
@Composable
fun VideoPlayer(context: Context, videoUri: String, modifier: Modifier) {
    var videoAspectRatio by remember { mutableFloatStateOf(16 / 9f) }

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(Uri.parse(videoUri))
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true // Reproduce automáticamente al cargar

            addListener(object : Player.Listener {
                override fun onVideoSizeChanged(videoSize: VideoSize) {
                    videoAspectRatio = if (videoSize.height != 0)
                        videoSize.width.toFloat() / videoSize.height
                    else
                        16 / 9f
                }

                override fun onIsPlayingChanged(isPlaying: Boolean) {
                    if (isPlaying) {
                        pause = true
                        mediaPlayer.pause()
                    } else {
                        pause = false
                        mediaPlayer.start()
                    }
                }

                override fun onPlaybackStateChanged(state: Int) {
                    // Cuando termine el video
                    if (state == Player.STATE_ENDED) {
                        pause = false
                        mediaPlayer.start()
                    }
                }


                override fun onPlayerError(error: PlaybackException) {
                    super.onPlayerError(error)
                    // Reanudar música si hubo un error en el video
                    pause = false
                    mediaPlayer.start()
                }

            })
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    AndroidView(
        factory = {
            PlayerView(context).apply {
                player = exoPlayer
                useController = true
            }
        },
        modifier = modifier.aspectRatio(videoAspectRatio)
    )
}