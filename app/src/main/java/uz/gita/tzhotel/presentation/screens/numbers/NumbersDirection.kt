package uz.gita.tzhotel.presentation.screens.numbers

import uz.gita.tzhotel.presentation.navigation.AppNavigator
import uz.gita.tzhotel.presentation.screens.order.OrderScreen
import javax.inject.Inject

class NumbersDirection @Inject constructor(
    private val appNavigator: AppNavigator
) : NumbersContract.Direction {
    override suspend fun openOrderScreen() {
        appNavigator.navigateTo(OrderScreen())
    }

    override suspend fun back() {
        appNavigator.back()
    }
}