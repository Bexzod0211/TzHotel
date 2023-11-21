package uz.gita.tzhotel.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.tzhotel.presentation.screens.hotel.HotelContract
import uz.gita.tzhotel.presentation.screens.hotel.HotelDirection
import uz.gita.tzhotel.presentation.screens.numbers.NumbersContract
import uz.gita.tzhotel.presentation.screens.numbers.NumbersDirection
import uz.gita.tzhotel.presentation.screens.order.BookContract
import uz.gita.tzhotel.presentation.screens.order.BookDirection
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @[Binds Singleton]
    fun bindHotelDirection(impl: HotelDirection): HotelContract.Direction


    @[Binds Singleton]
    fun bindNumbersDirection(impl:NumbersDirection):NumbersContract.Direction

    @[Binds Singleton]
    fun bindOrderDirection(impl:BookDirection):BookContract.Direction
}