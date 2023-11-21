package uz.gita.tzhotel.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import uz.gita.tzhotel.data.network.response.RoomsResponse
import uz.gita.tzhotel.domain.repository.AppRepository
import uz.gita.tzhotel.domain.usecase.NumbersUseCase
import javax.inject.Inject

class NumberssUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) :NumbersUseCase{
    override fun getRoomsList(): Flow<Result<RoomsResponse>>  = repository.getRoomsListResponse()


}