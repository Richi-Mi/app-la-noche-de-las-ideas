package com.ipn.escom.lni.ui.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipn.escom.lni.R
import com.ipn.escom.lni.ui.model.EventInfo
import com.ipn.escom.lni.ui.model.IslaInfo
import com.ipn.escom.lni.ui.model.Speaker
import com.ipn.escom.lni.ui.model.TipoEvento
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme
import java.time.LocalTime

@Composable
fun DetailScreen(id: Int, isla: IslaInfo) {
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(16.dp)
    ) {
        //Imagen de la isla con el nombre de la isla
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
        ) {
            Image(
                painter = painterResource(id = isla.image),
                contentDescription = isla.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(100.dp)
            )
            Text(
                text = isla.name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .background(Color(0xAA6A1B9A), shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "No te pierdas de: ",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        )

        ListOfCards(isla.events)

        FloatingActionButton(
            onClick = {
                abrirNavegador(context, isla.direction)
            },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.onTertiaryContainer)
                .align(Alignment.BottomEnd)
                .padding(15.dp)
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = "Ubicación", tint = Color.Red)
        }
    }
}

fun abrirNavegador (context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Composable
fun ListOfCards(events: List<EventInfo>) {
    Column {
        events.forEach { event ->
            CardEvent(event)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CardEvent(info: EventInfo) {
    Row (
        verticalAlignment  = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(0.dp, 30.dp,30.dp, 0.dp))
            .padding(16.dp)
    )
    {
        Text(
            text = info.hora.toString(),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(20.dp))
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Text(text = info.name, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = info.description, color = Color.DarkGray, fontSize = 12.sp)
        }
    }
}


@Preview
@Composable
fun CardPreview(){
    val eventos = listOf(
        EventInfo(
            "Nombre del evento",
            LocalTime.of(15, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez"), Speaker("Juan", "Perez")),
            TipoEvento.PELICULA
        ),
        EventInfo(
            "Nombre del evento2",
            LocalTime.of(17, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez"), Speaker("Juan", "Perez")),
            TipoEvento.PELICULA
        ),
        EventInfo(
            "Nombre del evento3",
            LocalTime.of(19, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez"), Speaker("Juan", "Perez")),
            TipoEvento.PELICULA
        )
    )
    val isl = IslaInfo("Isla de Utopía", R.drawable.ic_launcher_foreground, eventos, "https://www.google.com/maps/place/ESCA+-+Escuela+Superior+de+Comercio+y+Administraci%C3%B3n+Unidad+Santo+Tom%C3%A1s/")
    LaNocheDeLasIdeasTheme (darkTheme = false) {
        DetailScreen(1, isl)
    }
}