package uz.gita.tzhotel.presentation.screens.paid

interface PaidContract {

    interface ViewModel {
        fun onEventDispatcher(intent: Intent)
    }

    interface Direction {
        suspend fun backToHotelScreen()
    }

    sealed interface Intent {
        object Back:Intent
    }

}