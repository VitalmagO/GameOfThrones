package ru.skillbranch.gameofthrones

import android.app.Application
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.skillbranch.gameofthrones.data.api.GOTApi

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //client
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client: OkHttpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor(logging)
            .build()

        //json converter
        val gson: Gson = Gson()
            .newBuilder()
            .create()

        //retrofit
        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(AppConfig.BASE_URL)
            .build()

        gotApi = retrofit.create(GOTApi::class.java)
    }

    companion object {
        private lateinit var gotApi: GOTApi
        fun getApi() = gotApi
    }
}