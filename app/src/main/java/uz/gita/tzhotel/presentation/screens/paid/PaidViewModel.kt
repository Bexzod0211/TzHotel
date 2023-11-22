package uz.gita.tzhotel.presentation.screens.paid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaidViewModel @Inject constructor(
    private val direction: PaidContract.Direction,
): PaidContract.ViewModel,ViewModel(){


    override fun onEventDispatcher(intent: PaidContract.Intent) {
        when(intent){
            PaidContract.Intent.Back->{
                viewModelScope.launch {
                    direction.backToHotelScreen()
                }
            }
        }
    }
}