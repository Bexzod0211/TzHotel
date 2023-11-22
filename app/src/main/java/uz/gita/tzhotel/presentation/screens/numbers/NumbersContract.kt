package uz.gita.tzhotel.presentation.screens.numbers

import kotlinx.coroutines.flow.StateFlow
import uz.gita.tzhotel.data.network.response.RoomsResponse

interface NumbersContract {

    data class UiState(
        val response:RoomsResponse? = null,
        val isLoading:Boolean = false
    )

    interface Intent {
        object OrderNumberClicked:Intent
        object BackButtonClicked:Intent
    }

    interface ViewModel {
        val uiState:StateFlow<UiState>
        fun onEventDispatcher(intent: Intent)
    }

    interface Direction {
        suspend fun openOrderScreen()
        suspend fun back()
    }


}