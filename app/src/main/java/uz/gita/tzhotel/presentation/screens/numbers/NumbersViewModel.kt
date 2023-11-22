package uz.gita.tzhotel.presentation.screens.numbers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.gita.tzhotel.domain.usecase.NumbersUseCase
import javax.inject.Inject

@HiltViewModel
class NumbersViewModel @Inject constructor(
    private val useCase: NumbersUseCase,
    private val direction:NumbersContract.Direction
):NumbersContract.ViewModel, ViewModel(){
    override val uiState = MutableStateFlow(NumbersContract.UiState())

    init {
        loadData()
    }

    private fun loadData(){
        uiState.update {
            NumbersContract.UiState(isLoading = true)
        }
        useCase.getRoomsList()
            .onEach {result ->
            result.onSuccess {response->
                uiState.update {
                    NumbersContract.UiState(
                        response =  response,
                        isLoading = false
                    )
                }
            }
            result.onFailure {

            }

            }
            .launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: NumbersContract.Intent) {
        when(intent){
            NumbersContract.Intent.BackButtonClicked->{
                viewModelScope.launch {
                    direction.back()
                }
            }
            NumbersContract.Intent.OrderNumberClicked->{
                viewModelScope.launch {
                    direction.openOrderScreen()
                }
            }
        }
    }

}