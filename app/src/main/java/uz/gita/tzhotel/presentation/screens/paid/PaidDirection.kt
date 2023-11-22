package uz.gita.tzhotel.presentation.screens.paid

import uz.gita.tzhotel.presentation.navigation.AppNavigator
import uz.gita.tzhotel.presentation.screens.hotel.HotelScreen
import javax.inject.Inject

class PaidDirection @Inject constructor(
    private val appNavigator: AppNavigator
) : PaidContract.Direction{
    override suspend fun backToHotelScreen() {
        appNavigator.back()
    }
}