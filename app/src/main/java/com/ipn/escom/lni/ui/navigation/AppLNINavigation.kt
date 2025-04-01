package com.ipn.escom.lni.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
    composable( NavRoutes.infoScreen,
        arguments = listOf(
            navArgument( NavRoutes.arguments.id, builder = { type = NavType.IntType } )
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt( NavRoutes.arguments.id ) ?: 0
        DetailScreen( islasGlobal[id]) { id2 ->
            navController.navigate( NavRoutes.getEventRoute(id, id2 ) )
        }
    }
}

private fun NavGraphBuilder.addEventScreen(
    navController: NavHostController
) {
    composable(
        route =  NavRoutes.getEventRoute(),
        arguments = listOf(
            navArgument( NavRoutes.arguments.id, builder = { type = NavType.IntType } ),
            navArgument( NavRoutes.arguments.id2, builder = { type = NavType.IntType } )
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt( NavRoutes.arguments.id ) ?: 0
        val id2 = backStackEntry.arguments?.getInt( NavRoutes.arguments.id2 ) ?: 0
        val event = islasGlobal[id].events[id2]
        EventScreen( event )
    }
}