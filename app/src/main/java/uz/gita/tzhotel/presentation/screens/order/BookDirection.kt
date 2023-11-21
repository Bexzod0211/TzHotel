package uz.gita.tzhotel.presentation.screens.order

import uz.gita.tzhotel.presentation.navigation.AppNavigator
import javax.inject.Inject

class BookDirection @Inject constructor(
    private val appNavigator: AppNavigator
) :BookContract.Direction {
    override suspend fun back() {
        appNavigator.back()
    }

    override suspend fun openPaymentScreen() {

    }
}