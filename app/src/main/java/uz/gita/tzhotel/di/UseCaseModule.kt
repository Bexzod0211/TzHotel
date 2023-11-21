package uz.gita.tzhotel.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tzhotel.domain.usecase.HotelUseCase
import uz.gita.tzhotel.domain.usecase.NumbersUseCase
import uz.gita.tzhotel.domain.usecase.OrderUseCase
import uz.gita.tzhotel.domain.usecase.impl.HotelUseCaseImpl
import uz.gita.tzhotel.domain.usecase.impl.NumberssUseCaseImpl
import uz.gita.tzhotel.domain.usecase.impl.OrderUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @[Binds Singleton]
    fun bindHotelUseCase(impl:HotelUseCaseImpl): HotelUseCase

    @[Binds Singleton]
    fun bindRoomsUseCase(impl:NumberssUseCaseImpl):NumbersUseCase

    @[Binds Singleton]
    fun bindOrderUseCase(impl:OrderUseCaseImpl):OrderUseCase
}