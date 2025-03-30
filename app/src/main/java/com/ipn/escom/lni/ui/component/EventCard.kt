package com.ipn.escom.lni.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme

@Composable
fun EventCard( modifier: Modifier ) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth( 0.2f )
                .background( Color.Red )
                .clip( RoundedCornerShape( 10.dp ) )
                .align( Alignment.CenterStart )
                .padding( start = 32.dp )
        ) {
            Text("3:30PM")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth( 0.8f )
                .align( Alignment.CenterEnd )
                .background( Color.Yellow )
        ) {
            Text("Tema")
            Text("Breve DEscripcion")
        }
    }
}
@Composable
@Preview(
    showBackground = true,
    showSystemUi = true
)
fun EventPreview() {
    LaNocheDeLasIdeasTheme {

        Column {
            Spacer( Modifier.height( 100.dp ))
            EventCard( Modifier.align( Alignment.CenterHorizontally ))
        }
    }
}