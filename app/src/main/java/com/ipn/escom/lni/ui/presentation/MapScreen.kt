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
import com.ipn.escom.lni.NavRoutes
import com.ipn.escom.lni.R
import com.ipn.escom.lni.islasGlobal
import com.ipn.escom.lni.ui.model.IslaInfo
import com.ipn.escom.lni.ui.theme.LaNocheDeLasIdeasTheme

@Composable
fun CirclePoint( modifier: Modifier = Modifier, onCircleClicked: () -> Unit ) {
    Box( modifier = modifier
            .background(Color.Red.copy(alpha = 0.3f), CircleShape)
            .clip(CircleShape)
            .border(2.dp, Color.Red, CircleShape)
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
            val (fondo, U1, U2, U3, U4, U5, U6, I1, I2, I3, I4) = createRefs()
            val firstGuideline = createGuidelineFromTop(0.05f)
            val secondGuideline = createGuidelineFromEnd(0.25f)

            val middleGuideline = createGuidelineFromTop(0.5f)
            val middleGuidelineH = createGuidelineFromStart(0.5f)

            val bottomGuideline = createGuidelineFromBottom(0.2f)

            Image(
                painter = painterResource(R.drawable.mapautopias),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxSize()
                    .constrainAs(fondo) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
            )
            // Mundo de antes.
            CirclePoint(
                modifier = Modifier.size( width = 140.dp, height = 104.dp)
                .constrainAs(U1) {
                    top.linkTo(firstGuideline)
                    start.linkTo(parent.start, margin = 32.dp)
                }) {
                idIsland = 17
                showDialog = true
            }

            // Mundo que viene.
            CirclePoint( modifier = Modifier.size(104.dp)
                .constrainAs(U2) {
                    top.linkTo(firstGuideline)
                    end.linkTo(secondGuideline)
                }) {
                idIsland = 18
                showDialog = true

            }
            // Espiritualidades y religiones
            CirclePoint( modifier = Modifier.size(104.dp)
                .constrainAs(U3) {
                    top.linkTo(firstGuideline, margin = 108.dp)
                    start.linkTo(parent.start, margin = 32.dp)
                }) {
                idIsland = 20
                showDialog = true


            }
            // Utopias vs distopias
            CirclePoint( modifier = Modifier.size(width = 88.dp, height = 124.dp)
                .constrainAs(U4) {
                    top.linkTo(firstGuideline, margin = 104.dp)
                    end.linkTo(secondGuideline, margin = 48.dp)
                }) {
                idIsland = 10
                showDialog = true

            }
            CirclePoint( modifier = Modifier.size(width = 96.dp, height = 124.dp)
                .constrainAs(U5) {
                    bottom.linkTo(middleGuideline, margin = 24.dp)
                    end.linkTo(middleGuidelineH, margin = 16.dp)
                }) {
                idIsland = 13
                showDialog = true

            }
            /// Utopias
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
            // Artes
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
            // Extraterrestres.
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
            // Fabrica del cuerpo
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
        }
        if (showDialog){
            DialogUtopia(
                onDismiss = { showDialog = false },
                onViewClick = {
                    showDialog = false
                    navHostController.navigate( NavRoutes.getDetailRoute(10) )
                },
                islasGlobal[idIsland]
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