package com.ipn.escom.lni.ui.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun DetailScreen(isla: IslaInfo) {
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        AnimatedStarsBackground()
        Column (modifier = Modifier.fillMaxSize()){
            //Imagen de la isla con el nombre de la isla
            Box(modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = isla.image),
                    contentDescription = isla.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(150.dp).align(Alignment.Center)
                )
                Text(
                    text = isla.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
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
            )

            Spacer(modifier = Modifier.height(15.dp))

            ListOfCards(isla.events)
        }

        FloatingActionButton(
            onClick = {
                abrirNavegador(context, isla.direction)
            },
            modifier = Modifier
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
fun ListOfCards (events: List<EventInfo>) {
    LazyColumn {
        items(events) { event ->
            CardEvent(event)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CardEvent (info: EventInfo) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                expanded =! expanded
            }
    ){
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(0.dp, 30.dp, 30.dp, 0.dp))
                .fillMaxWidth(0.85f)
                .align(Alignment.TopEnd)
                .heightIn(min = 60.dp)
        ){
            Column (
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = info.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 50.dp)
                )
                if(!expanded)
                    Text(text = info.description, color = Color.DarkGray, fontSize = 12.sp,
                        modifier = Modifier.padding(start = 50.dp))
                else
                    CardOpen(info.exponents)
            }
        }
        Box (
            modifier = Modifier
                .padding(top = 10.dp)
                .height(40.dp)
                .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(20.dp))
                .align(Alignment.TopStart)
        ){
            Text(
                text = info.hora.toString() + " PM",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }
    }
}

@Composable
fun CardOpen (exponents: List<Speaker>) {
    Column (Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.height(8.dp))
        exponents.forEach { exponent ->
            Image(
                painter = painterResource(id = exponent.image),
                contentDescription = exponent.name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = exponent.name,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            if(exponent.institute != "") {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = exponent.institute,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = exponent.biography,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun CardPreview () {
    val eventos = listOf(
        EventInfo(
            "Nombre del evento",
            LocalTime.of(15, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla"), Speaker("Juan", "Perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla")),
            TipoEvento.PELICULA
        ),
        EventInfo(
            "Nombre del evento2",
            LocalTime.of(17, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla"), Speaker("Juan", "Perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla")),
            TipoEvento.PELICULA
        ),
        EventInfo(
            "Nombre del evento3",
            LocalTime.of(19, 0),
            "Este es un evento xd",
            listOf(Speaker("Juan", "perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla"), Speaker("Juan", "Perez", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla")),
            TipoEvento.PELICULA
        )
    )
    val isl = IslaInfo("Isla de Utopía", R.drawable.ic_launcher_foreground, eventos, "https://www.google.com/maps/place/ESCA+-+Escuela+Superior+de+Comercio+y+Administraci%C3%B3n+Unidad+Santo+Tom%C3%A1s/")
    LaNocheDeLasIdeasTheme (darkTheme = false) {
        DetailScreen(isl)
    }
}