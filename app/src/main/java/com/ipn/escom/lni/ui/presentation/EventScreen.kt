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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.ipn.escom.lni.ui.model.Speaker
import com.ipn.escom.lni.ui.model.TipoEvento
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme
import java.time.LocalTime

@Composable
fun EventScreen(event: EventInfo) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)){
        AnimatedStarsBackground()
        Column (
            modifier = Modifier
                .fillMaxSize()
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
                EventDetailRow(Icons.Default.Info, "Tipo de evento", event.type.toString())
                EventDetailRow(Icons.Default.Check, "Descripción", event.description)
                if(event.exponents != null) {
                    event.exponents.forEach { speaker: Speaker ->
                        ExponentsDetails(speaker)
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
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
            .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(20.dp))
    )
    {
        Icon(icon, title, tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 8.dp))

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = content,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ExponentsDetails (exponent: Speaker) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.tertiaryContainer, shape = RoundedCornerShape(20.dp))
    )
    {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = exponent.image),
                modifier = Modifier
                    .clip(CircleShape)
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
    }
}

fun abrirNavegador (context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

@Preview
@Composable
fun PreviewEvent (){
    val event = EventInfo(
        "Nombre del evento3",
        LocalTime.of(19, 0),
        LocalTime.of(21, 0),
        "Este es un evento xd",
        listOf(Speaker("Juan", R.drawable.logo, "Esta es mi biografia, blablalbalbalblabla"), Speaker("Juan", R.drawable.ic_launcher_foreground, "Esta es mi biografia, blablalbalbalblabla")),
        TipoEvento.PELICULA,
        "Auditorio B5",
        "https://maps.app.goo.gl/JnjrvTS1H3rKpvHh9"
    )
    LaNocheDeLasIdeasTheme (darkTheme = false) {
        EventScreen(event)
    }
}