package uz.gita.tzhotel.presentation.navigation

import cafe.adriel.voyager.androidx.AndroidScreen

typealias AppScreen = AndroidScreen

interface AppNavigator {

    suspend fun back()
    suspend fun backAll()
    suspend fun navigateTo(screen:AppScreen)
    suspend fun replace(screen:AppScreen)
    suspend fun replaceAll(screen: AppScreen)
}