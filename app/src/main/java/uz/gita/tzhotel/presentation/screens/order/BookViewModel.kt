package uz.gita.tzhotel.presentation.screens.order

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
    private val direction: BookContract.Direction,
) : BookContract.ViewModel, ViewModel() {
    override val uiState = MutableStateFlow(BookContract.UiState())
    private var isButtonClicked:Int = 0
    init {
        loadData()
    }

    private fun loadData(isLoading:Boolean = false,errorList:List<MutableState<Boolean>>? = null,infoIsLoading:Boolean = false) {

            uiState.update {
                BookContract.UiState(
                    isLoading = !infoIsLoading,
                    infoIsLoading = true
                )
            }

        useCase.getNumberInfo()
            .onEach { result ->
                result.onSuccess { response ->
                    uiState.update {
                        BookContract.UiState(
                            orderInfo = response,
                            isLoading = false,
                            errorList = errorList,
                            infoIsLoading = false
                        )
                    }
                }

                result.onFailure {
                    myLog("${it.message}")
                }
            }
            .launchIn(viewModelScope)
    }

    override fun onEventDispatcher(intent: BookContract.Intent) {
        when (intent) {
            BookContract.Intent.BackButtonClicked -> {
                viewModelScope.launch {
                    direction.back()
                }
            }

            is BookContract.Intent.BlueButtonClicked -> {
                if (intent.isButtonClicked){
                    isButtonClicked++
                }

                val list = mutableListOf<MutableState<Boolean>>()

                var hasMistake: Boolean
//                myLog("${intent.list[0].trim().length}")

                var phoneNumber = intent.list[0].trim().length != 10
                var email = intent.list[1].trim().length < 9 || !intent.list[1].trim().contains("@mail.ru")

                hasMistake = phoneNumber || email

                list.add(mutableStateOf(value = phoneNumber))

                list.add(mutableStateOf(value = email))

                for (i in 2 until intent.list.size) {
                    var bool = intent.list[i].trim().isEmpty()
                    hasMistake = hasMistake || bool
                    list.add(mutableStateOf(bool))
                }

                if (hasMistake && isButtonClicked!=0) {
                    loadData(errorList = list, infoIsLoading = true)
                }
                else if (intent.isButtonClicked) {
                    viewModelScope.launch {
                        direction.openPaymentScreen()
                    }
                }

            }
        }
    }


}