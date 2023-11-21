package uz.gita.tzhotel.presentation.screens.hotel

import uz.gita.tzhotel.presentation.navigation.AppNavigator
import uz.gita.tzhotel.presentation.screens.numbers.NumbersScreen
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject

class HotelDirection @Inject constructor(
    private val appNavigator: AppNavigator
): HotelContract.Direction {
    override suspend fun openNumberScreen(name:String) {
        myLog("HotelDirection onClick")
        appNavigator.navigateTo(NumbersScreen(name))
    }
}