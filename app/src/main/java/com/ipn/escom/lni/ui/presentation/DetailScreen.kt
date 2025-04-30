package com.ipn.escom.lni.ui.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavHostController
import com.ipn.escom.lni.R
import com.ipn.escom.lni.islasGlobal
import com.ipn.escom.lni.mediaPlayer
import com.ipn.escom.lni.pause
import com.ipn.escom.lni.ui.model.EventInfo
import com.ipn.escom.lni.ui.model.IslaInfo
import com.ipn.escom.lni.ui.model.Speaker
import com.ipn.escom.lni.ui.model.TipoEvento
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme
import java.time.LocalTime

@Composable
fun DetailScreen( isla: IslaInfo , onClick: (Int) -> Unit) {

    if(pause){
        pause = false
        mediaPlayer.start()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF10131A))
        .padding(16.dp)
    ) {
        AnimatedStarsBackground()
        Column (
            modifier = Modifier.fillMaxSize()
        ){
            ListOfCards(isla, isla.events, onClick)
        }
    }
}


@Composable
fun ListOfCards ( isla: IslaInfo, events: List<EventInfo>, onClick: ( Int ) -> Unit) {

    LazyColumn{
        item {
            //Imagen de la isla con el nombre de la isla
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
            ) {
                Icon(
                    painter = painterResource( isla.image ),
                    contentDescription = isla.name,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size( 64.dp )
                )
                Text(
                    text = isla.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background( MaterialTheme.colorScheme.primaryContainer, shape = RoundedCornerShape(16.dp))
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
        }
        items(events.size) { id ->
            CardEvent(events[id]) {
                onClick( id )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun CardEvent (info: EventInfo, onClick: () -> Unit) {
    var texto = ""

    if(info.description != "") {
        texto = info.description
    } else {
        info.exponents?.forEach { speaker ->
            texto += speaker.name + "\n"
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onClick()
            }
    ){
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer, shape = RoundedCornerShape(10.dp))
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
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier
                        .padding(start = 50.dp)
                )
                Text(text = texto
                    ,color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 50.dp))
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
                text = info.startHora.toString() + " PM",
                color = MaterialTheme.colorScheme.onTertiaryContainer,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }
    }
}
