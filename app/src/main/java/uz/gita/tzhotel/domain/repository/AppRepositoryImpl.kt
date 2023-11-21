package uz.gita.tzhotel.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.tzhotel.data.network.api.BaseApi
import uz.gita.tzhotel.data.network.response.OrderResponse
import uz.gita.tzhotel.data.network.response.HotelDataResponse
import uz.gita.tzhotel.data.network.response.RoomsResponse
import uz.gita.tzhotel.utils.myLog
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    val api:BaseApi
): AppRepository {

    override fun getHotelInfo(): Flow<Result<HotelDataResponse>>  = flow{
        val response = api.getHotelInfo()

        if (response.isSuccessful){
            response.body()?.let {
                emit(Result.success(it))
            }
        }else {
            response.errorBody()?.let {
                myLog(it.string())
            }
        }

    }

    override fun getRoomsListResponse(): Flow<Result<RoomsResponse>>  = flow{
        val response = api.getRoomsList()

        if (response.isSuccessful){
            response.body()?.let {
                emit(Result.success(it))
            }
        }else {
            response.errorBody()?.let {
                myLog(it.string())
            }
        }
    }

    override fun getNumberInfo(): Flow<Result<OrderResponse>>  = flow{
        val response = api.getNumberInfo()

        if (response.isSuccessful){
            response.body()?.let {
                emit(Result.success(it))
            }
        }else {
            response.errorBody()?.let {
                myLog(it.string())
            }
        }
    }
}