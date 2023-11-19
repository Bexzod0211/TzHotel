package uz.gita.tzhotel.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tzhotel.presentation.screens.hotel.HotelContract
import uz.gita.tzhotel.presentation.screens.hotel.HotelDirection
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @[Binds Singleton]
    fun bindHotelDirection(impl: HotelDirection): HotelContract.Direction
}