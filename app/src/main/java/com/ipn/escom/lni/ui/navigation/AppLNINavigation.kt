package com.ipn.escom.lni.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipn.escom.lni.NavRoutes
import com.ipn.escom.lni.islasGlobal
import com.ipn.escom.lni.ui.presentation.DetailScreen
import com.ipn.escom.lni.ui.presentation.EventScreen
import com.ipn.escom.lni.ui.presentation.HomeScreen
import com.ipn.escom.lni.ui.presentation.ScrollableMap

@Composable
fun AppLNINavigation() {
    val applninavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavHost(
            navController = applninavController,
            startDestination = NavRoutes.startScreen
        ) {
            addStartScreen( applninavController, innerPadding )
            addMapScreen( applninavController, innerPadding )
            addDetailScreen( applninavController )
            addEventScreen( applninavController)
        }
    }
}
private fun NavGraphBuilder.addStartScreen(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    composable( NavRoutes.startScreen ) {
        HomeScreen( innerPadding ) {
            navController.navigate( NavRoutes.mapScreen )
        }
    }
}
private fun NavGraphBuilder.addMapScreen(
    navController: NavController,
    innerPadding: PaddingValues
) {
    composable( NavRoutes.mapScreen ) {
        ScrollableMap(
            navController,
            innerPadding
        )
    }
}
private fun NavGraphBuilder.addDetailScreen(
    navController: NavHostController
) {
    composable( NavRoutes.getDetailRoute() ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt( NavRoutes.arguments.id ) ?: 0
        DetailScreen( navController, islasGlobal[id]) {

        }
    }
}

private fun NavGraphBuilder.addEventScreen(
    navController: NavHostController
) {
    composable( NavRoutes.eventScreen ) {
            //EventScreen()
    }
}