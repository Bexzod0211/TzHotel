package uz.gita.tzhotel.presentation.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.Flow

typealias NavigationArgs = Navigator.()->Unit

interface NavigationHandler {
    val navigationBuffer:Flow<NavigationArgs>

}