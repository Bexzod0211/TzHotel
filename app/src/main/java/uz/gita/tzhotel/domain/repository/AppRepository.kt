package uz.gita.tzhotel.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.OrderResponse
import uz.gita.tzhotel.data.network.response.HotelDataResponse
import uz.gita.tzhotel.data.network.response.RoomsResponse

interface AppRepository {

    fun getHotelInfo():Flow<Result<HotelDataResponse>>
    fun getRoomsListResponse():Flow<Result<RoomsResponse>>
    fun getNumberInfo():Flow<Result<OrderResponse>>

}