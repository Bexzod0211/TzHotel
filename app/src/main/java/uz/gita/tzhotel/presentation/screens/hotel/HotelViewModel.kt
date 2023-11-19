package uz.gita.tzhotel.presentation.screens.hotel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import uz.gita.tzhotel.domain.usecase.HotelUseCase
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject

@HiltViewModel
class HotelViewModel @Inject constructor(
    private val useCase: HotelUseCase,
    private val direction: HotelContract.Direction,
) : HotelContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(HotelContract.UiState())

    init {
        myLog("init")
        loadData()
    }

    private fun loadData() {
        useCase.getHotelInfo()
            .onEach { result ->
                result.onSuccess {request->
                    uiState.update {
                        HotelContract.UiState(hotelInfo = request)
                    }
                }
                result.onFailure {
                    myLog(it.message?:"")
                }

            }
            .launchIn(viewModelScope)
    }


    override fun onEventDispatcher(intent: HotelContract.Intent) {
        when (intent) {
            HotelContract.Intent.SelectNumberClicked -> {

            }
        }
    }

}