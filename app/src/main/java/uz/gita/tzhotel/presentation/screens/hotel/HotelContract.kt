package uz.gita.tzhotel.presentation.screens.hotel

import kotlinx.coroutines.flow.StateFlow
import uz.gita.tzhotel.data.network.response.HotelDataResponse

interface HotelContract {
    data class UiState(
        val hotelInfo:HotelDataResponse? = null,
        val isLoading:Boolean = false
    )

    sealed interface Intent {
        data class SelectNumberClicked(val hotelName:String): Intent
    }

    interface ViewModel {
        val uiState:StateFlow<UiState>
        fun onEventDispatcher(intent: Intent)
    }

    sealed interface SideEffect {
        data class Toast(val message:String): SideEffect
    }

    interface Direction {
        suspend fun openNumberScreen(name:String)
    }

}