package uz.gita.tzhotel.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.HotelDataResponse
import uz.gita.tzhotel.domain.repository.AppRepository
import uz.gita.tzhotel.domain.usecase.HotelUseCase
import javax.inject.Inject

class HotelUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) :HotelUseCase{
    override fun getHotelInfo(): Flow<Result<HotelDataResponse>> = repository.getHotelInfo()

}