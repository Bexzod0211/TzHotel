package uz.gita.tzhotel.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.RoomsResponse

interface NumbersUseCase {

    fun getRoomsList():Flow<Result<RoomsResponse>>

}