package uz.gita.tzhotel.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.OrderResponse
import uz.gita.tzhotel.domain.repository.AppRepository
import uz.gita.tzhotel.domain.usecase.OrderUseCase
import javax.inject.Inject

class OrderUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) : OrderUseCase{
    override fun getNumberInfo(): Flow<Result<OrderResponse>>  = repository.getNumberInfo()
}