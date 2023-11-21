package uz.gita.tzhotel.presentation.screens.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.gita.tzhotel.domain.usecase.OrderUseCase
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val useCase: OrderUseCase,
    private val direction: BookContract.Direction
): BookContract.ViewModel,ViewModel() {
    override val uiState = MutableStateFlow(BookContract.UiState())

    init {
        loadData()
    }

    private fun loadData(){
        useCase.getNumberInfo()
            .onEach {result ->
                result.onSuccess {response->
                    uiState.update {
                        BookContract.UiState(response)
                    }
                }

                result.onFailure {
                    myLog("${it.message}")
                }
            }
            .launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: BookContract.Intent) {
        when(intent) {
            BookContract.Intent.BackButtonClicked->{
                viewModelScope.launch {
                    direction.back()
                }
            }
        }
    }


}