package com.example.databaseremote.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.databaseremote.uicontroller.route.DestinasiEntry
import com.example.databaseremote.uicontroller.route.DestinasiHome
import com.example.databaseremote.view.EntrySiswaScreen
import com.example.databaseremote.view.HomeScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier){
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiHome.route,
        modifier = Modifier ){
        composable(DestinasiHome.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetail.route}/${it}")
                })
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome
                .route) })
        }
        composable(DestinasiDetail.routeWithArgs,arguments = listOf(navArgument(DestinasiDetail
            .itemIdArg) {
            type = NavType.IntType })
        ){
            DetailSiswaScreen(navigateToEditItem = {navController.navigate("${DestinasiEdit.route}
                /$it")},
                navigateBack = { navController.navigate(DestinasiHome.route) })
        }
        composable(DestinasiEdit.routeWithArgs, arguments = listOf(navArgument(DestinasiEdit.itemIdArg
            ){
            type = NavType.IntType}){
            EditSiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route) },
                onNavigateUp = { navController.navigateUp() })
        }
    }
}