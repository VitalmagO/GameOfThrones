package ru.skillbranch.gameofthrones

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import java.net.HttpURLConnection
import java.net.URL

fun createRequest(url: String) = Observable.create<String> {
    val urlConnection = URL(url).openConnection() as HttpURLConnection
    try {
        urlConnection.connect()

        if (urlConnection.responseCode != HttpURLConnection.HTTP_OK)
            it.onError(RuntimeException(urlConnection.responseMessage))
        else {
            val str = urlConnection.inputStream.bufferedReader().readText()
            it.onNext(str)
        }
    } finally {
        urlConnection.disconnect()
    }
}

fun <T> Observable<T>.async(): Observable<T> = subscribeOn(
    RxSchedulers.io()
).observeOn(
    RxSchedulers.main()
)

fun <T> Single<T>.async(): Single<T> = subscribeOn(
    RxSchedulers.io()
).observeOn(
    RxSchedulers.main()
)

fun <T> Observable<T>.subscribeLog(): Disposable? = subscribe({
    Log.w("request", "$it")
}, {
    Log.e("requestError", "", it)
})

fun <T> Single<T>.subscribeLog(): Disposable? = subscribe({
    Log.w("request", "$it")
}, {
    Log.e("requestError", "", it)
})