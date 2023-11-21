package uz.gita.tzhotel.presentation.screens.order

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.flow.StateFlow
import uz.gita.tzhotel.data.network.response.OrderResponse

interface BookContract {

    data class UiState(
        val orderInfo:OrderResponse? = null,
        val errorList:List<MutableState<Boolean>>? = null
    )

    sealed interface Intent {
        object BackButtonClicked:Intent
    }

    interface ViewModel {
        val uiState:StateFlow<UiState>

        fun onEventDispatcher(intent:Intent)
    }


    interface Direction {
        suspend fun back()
        suspend fun openPaymentScreen()
    }

}