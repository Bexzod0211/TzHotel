package uz.gita.tzhotel.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.tzhotel.data.network.response.OrderResponse
import uz.gita.tzhotel.data.network.response.HotelDataResponse
import uz.gita.tzhotel.data.network.response.RoomsResponse

interface BaseApi {

    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo():Response<HotelDataResponse>

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoomsList():Response<RoomsResponse>

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getNumberInfo():Response<OrderResponse>
}