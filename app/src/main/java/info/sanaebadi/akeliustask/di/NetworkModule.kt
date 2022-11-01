package info.sanaebadi.akeliustask.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import info.sanaebadi.akeliustask.BuildConfig
import info.sanaebadi.akeliustask.network.base.ApplicationJsonAdapterFactory
import info.sanaebadi.akeliustask.network.base.TLSSocketFactory
import info.sanaebadi.akeliustask.network.base.UnitConverterFactory
import info.sanaebadi.akeliustask.network.service.AssetsRetrofitServices
import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi
            .Builder()
            .add(ApplicationJsonAdapterFactory)
            .build()

    @Provides
    @Singleton
    fun provideMoshiConverter(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        okHttpClientBuilder(httpLoggingInterceptor).build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi, httpClient: OkHttpClient): Retrofit {
        return retrofitBuilder(moshi)
            .client(httpClient)
            .build()
    }

    private fun okHttpClientBuilder(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .dispatcher(Dispatcher(Executors.newFixedThreadPool(20)).apply {
                maxRequests = 20
                maxRequestsPerHost = 20
            })
            .connectionPool(ConnectionPool(100, 30L, TimeUnit.SECONDS))
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(30L, TimeUnit.SECONDS)
            .writeTimeout(30L, TimeUnit.SECONDS)
            .connectTimeout(30L, TimeUnit.SECONDS)
            .sslSocketFactory(
                TLSSocketFactory(),
                TLSSocketFactory().trustManager
            )
    }

    private fun retrofitBuilder(moshi: Moshi): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(UnitConverterFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
    }

    @Provides
    @Singleton
    fun provideAssetsRetrofitService(retrofit: Retrofit): AssetsRetrofitServices =
        retrofit.create(AssetsRetrofitServices::class.java)

}