package uz.gita.tzhotel.presentation.screens.order

import uz.gita.tzhotel.presentation.navigation.AppNavigator
import uz.gita.tzhotel.presentation.screens.hotel.HotelScreen
import uz.gita.tzhotel.presentation.screens.paid.PaidScreen
import javax.inject.Inject

class BookDirection @Inject constructor(
    private val appNavigator: AppNavigator
) :BookContract.Direction {
    override suspend fun back() {
        appNavigator.back()
    }

    override suspend fun openPaymentScreen() {
        appNavigator.replaceAll(mutableListOf(HotelScreen(),PaidScreen()))
    }
}