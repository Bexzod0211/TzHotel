package uz.gita.tzhotel.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.tzhotel.data.network.api.BaseApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    val BASE_URL = "https://run.mocky.io/v3/"

    @[Provides Singleton]
    fun provideClient(
        @ApplicationContext context:Context
    ):OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor.Builder(context).build()).build()

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideBaseApi(retrofit: Retrofit):BaseApi = retrofit.create(BaseApi::class.java)
}