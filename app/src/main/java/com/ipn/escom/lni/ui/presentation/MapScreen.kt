package com.ipn.escom.lni.ui.presentation


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ipn.escom.lni.NavRoutes
import com.ipn.escom.lni.R
import com.ipn.escom.lni.islasGlobal
import com.ipn.escom.lni.ui.model.IslaInfo
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme

@Composable
fun CirclePoint( modifier: Modifier = Modifier, onCircleClicked: () -> Unit ) {
    Box( modifier = modifier
            .background(Color.Black.copy(alpha = 0.05f), CircleShape)
            .clip(CircleShape)
            .clickable {
                onCircleClicked()
            }
    )
}
@Composable
fun ScrollableMap(
    navHostController: NavController,
    innerPaddingValues: PaddingValues
) {
    var showDialog by remember { mutableStateOf(false) }
    var idIsland by remember { mutableStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(innerPaddingValues)
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (fondo, U1, U2, U3, U4, U5, U6, U7, U8, U9, M ) = createRefs()
            val (I1, I2, I3, I4, I5, I6, I7, I8, I9, I10) = createRefs()
            val firstGuideline = createGuidelineFromTop(0.05f)
            val secondGuideline = createGuidelineFromEnd(0.25f)

            val middleGuideline = createGuidelineFromTop(0.5f)
            val middleGuidelineH = createGuidelineFromStart(0.5f)

            val bottomGuideline = createGuidelineFromBottom(0.2f)

            Image(
                painter = painterResource(R.drawable.mapautopias),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(fondo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )
            // Isla: Mundo de antes.
            CirclePoint(
                modifier = Modifier.size( width = 140.dp, height = 104.dp)
                .constrainAs(U1) {
                    top.linkTo(firstGuideline)
                    start.linkTo(parent.start, margin = 32.dp)
                }) {
                idIsland = 17
                showDialog = true
            }

            // Isla: Mundo que viene.
            CirclePoint( modifier = Modifier.size(104.dp)
                .constrainAs(U2) {
                    top.linkTo(firstGuideline)
                    end.linkTo(secondGuideline)
                }) {
                idIsland = 18
                showDialog = true
            }
            // Isla: Mundo que viene: Futuro.
            CirclePoint( modifier = Modifier.size(72.dp)
                .constrainAs(U7) {
                    top.linkTo(U2.top, margin = (-16).dp)
                    start.linkTo(secondGuideline)
                }) {
                idIsland = 19
                showDialog = true
            }
            // Isla: Espiritualidades y religiones
            CirclePoint( modifier = Modifier.size(104.dp)
                .constrainAs(U3) {
                    top.linkTo(firstGuideline, margin = 108.dp)
                    start.linkTo(parent.start, margin = 32.dp)
                }) {
                idIsland = 20
                showDialog = true
            }
            // Isla: Utopias vs distopias
            CirclePoint( modifier = Modifier.size(width = 88.dp, height = 104.dp)
                .constrainAs(U4) {
                    top.linkTo(firstGuideline, margin = 140.dp)
                    end.linkTo(secondGuideline, margin = 48.dp)
                }) {
                idIsland = 10
                showDialog = true

            }
            // Isla: Utopias vs distopias: Satelite 1
            CirclePoint( modifier = Modifier.size(64.dp)
                .constrainAs(U8) {
                    bottom.linkTo(U4.top)
                    start.linkTo(U4.start)
                }) {
                idIsland = 11
                showDialog = true
            }
            // Isla: Utopias vs distopias: Satelite 2
            CirclePoint( modifier = Modifier.size(80.dp)
                .constrainAs(U9) {
                    bottom.linkTo(U4.top, margin = (-16).dp)
                    start.linkTo(U4.end, margin = 32.dp)
                }) {
                idIsland = 12
                showDialog = true
            }
            // Isla: Ciencia y tecnología
            CirclePoint( modifier = Modifier.size(width = 96.dp, height = 124.dp)
                .constrainAs(U5) {
                    bottom.linkTo(middleGuideline, margin = 24.dp)
                    end.linkTo(middleGuidelineH, margin = 16.dp)
                }) {
                idIsland = 13
                showDialog = true

            }
            // Isla: Utopia
            CirclePoint(
                modifier = Modifier.size(112.dp)
                    .constrainAs(U6) {
                        bottom.linkTo(middleGuideline, margin = 80.dp)
                        start.linkTo(middleGuidelineH, margin = 48.dp)
                    }
            ) {
                idIsland = 0
                showDialog = true

            }
            // Isla: Calle manuel carpio
            CirclePoint(
                modifier = Modifier.size(120.dp)
                    .constrainAs(M) {
                        bottom.linkTo(middleGuideline, margin = (-60).dp)
                        start.linkTo(middleGuidelineH, margin = (-30).dp)
                    }
            ) {
                idIsland = 16
                showDialog = true

            }
            // Isla: Artes
            CirclePoint(
                modifier = Modifier.size(104.dp)
                    .constrainAs(I1) {
                        bottom.linkTo(bottomGuideline, margin = 16.dp)
                        start.linkTo(parent.start, margin = 42.dp)
                    }
            ) {
                idIsland = 14
                showDialog = true

            }
            // Isla: Artes - Satelite 1
            CirclePoint(
                modifier = Modifier.size(72.dp)
                    .constrainAs(I9) {
                        bottom.linkTo(I1.bottom, margin = (-16).dp)
                        start.linkTo(I1.end)
                    }
            ) {
                idIsland = 15
                showDialog = true
            }
            // Isla: Artes - Satelite 2
            CirclePoint(
                modifier = Modifier.size(88.dp)
                    .constrainAs(I10) {
                        bottom.linkTo(I1.top, margin = (-16).dp)
                        start.linkTo(I1.end, margin = (-16).dp)
                    }
            ) {
                idIsland = 1
                showDialog = true
            }
            // Isla: Extraterrestres.
            CirclePoint(
                modifier = Modifier.size(104.dp)
                    .constrainAs(I2) {
                        bottom.linkTo(bottomGuideline, margin = 16.dp)
                        start.linkTo(middleGuidelineH, margin = 44.dp)
                    }
            ) {
                idIsland = 2
                showDialog = true
            }
            // Isla: Extraterrestres - Satelite 1.
            CirclePoint(
                modifier = Modifier.size(80.dp)
                    .constrainAs(I8) {
                        bottom.linkTo(I2.top)
                        start.linkTo(I2.start, margin = (-8).dp)
                    }
            ) {
                showDialog = true
                idIsland = 3
            }
            // Isla: Extraterrestres - Satelite 2.
            CirclePoint(
                modifier = Modifier.size(width = 120.dp, height = 64.dp)
                    .constrainAs(I7) {
                        bottom.linkTo(I5.top, margin = 16.dp)
                        start.linkTo(I4.end, margin = 16.dp)
                    }
            ) {
                showDialog = true
                idIsland = 4
            }
            // Isla: Fabrica del cuerpo
            CirclePoint(
                modifier = Modifier.size(96.dp)
                    .constrainAs(I3) {
                        top.linkTo(bottomGuideline, margin = 48.dp)
                        end.linkTo(parent.end, margin = 16.dp)
                    }
            ) {
                idIsland = 5
                showDialog = true

            }
            // Isla: Utopias Urbanas.
            CirclePoint(
                modifier = Modifier.size(width = 96.dp, height = 112.dp)
                    .constrainAs(I4) {
                        top.linkTo(bottomGuideline, margin = 24.dp)
                        end.linkTo(middleGuidelineH, margin = 16.dp)
                    }
            ) {
                idIsland = 7
                showDialog = true
            }
            // Utopias Urbanas - Satelite 1.
            CirclePoint(
                modifier = Modifier.size(width = 80.dp, height = 72.dp)
                    .constrainAs(I5) {
                        bottom.linkTo(I4.bottom, margin = (-16).dp)
                        start.linkTo(I4.end)
                    }
            ) {
                idIsland = 8
                showDialog = true
            }
            // Utopias Urbanas - Satelite 2.
            CirclePoint(
                modifier = Modifier.size(width = 72.dp, height = 102.dp)
                    .constrainAs(I6) {
                        top.linkTo(I4.top, margin = (-16).dp)
                        end.linkTo(I4.start)
                    }
            ) {
                idIsland = 9
                showDialog = true
            }
        }
        if (showDialog){
            DialogUtopia(
                onDismiss = { showDialog = false },
                onViewClick = {
                    showDialog = false
                    navHostController.navigate( NavRoutes.getDetailRoute(idIsland) )
                },
                islasGlobal[idIsland]
            )
        }
    }
}
@Preview
@Composable
fun ScrollableMapPreview() {
    LaNocheDeLasIdeasTheme {
        ScrollableMap(
            rememberNavController(),
            PaddingValues(0.dp)
        )
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