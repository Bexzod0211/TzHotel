package uz.gita.tzhotel.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.HotelDataResponse

interface HotelUseCase {
    fun getHotelInfo():Flow<Result<HotelDataResponse>>
}