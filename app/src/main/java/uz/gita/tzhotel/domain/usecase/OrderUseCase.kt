package uz.gita.tzhotel.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.OrderResponse

interface OrderUseCase {
    fun getNumberInfo():Flow<Result<OrderResponse>>
}