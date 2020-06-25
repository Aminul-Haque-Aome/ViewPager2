package com.aomi.mybase.extension

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import java.lang.Exception

fun <T> Single<Response<T>>.toSingle(): Single<T> {
    return map {
        if(it.isSuccessful) {
            if(it.body() != null) {
                it.body()
            } else {
                throw Exception("Empty Body")
            }
        } else {
            throw Exception("Status Code : ${it.code()} -> ${it.message()}")
        }
    }
}

fun <T> Observable<Response<T>>.toObservable(): Observable<T> {
    return map {
        if(it.isSuccessful) {
            if(it.body() != null) {
                it.body()
            } else {
                throw Exception("Empty Body")
            }
        } else {
            throw Exception("Status Code : ${it.code()} -> ${it.message()}")
        }
    }
}

fun <T> Flowable<Response<T>>.toFlowable(): Flowable<T> {
    return map {
        if(it.isSuccessful) {
            if(it.body() != null) {
                it.body()
            } else {
                throw Exception("Empty Body")
            }
        } else {
            throw Exception("Status Code : ${it.code()} -> ${it.message()}")
        }
    }
}

fun <T> Maybe<Response<T>>.toMaybe(): Maybe<T> {
    return map {
        if(it.isSuccessful) {
            if(it.body() != null) {
                it.body()
            } else {
                throw Exception("Empty Body")
            }
        } else {
            throw Exception("Status Code : ${it.code()} -> ${it.message()}")
        }
    }
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

fun <T> Observable<T>.performOnBackgroundOutputOnMain(): Observable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.performOnBackgroundOutputOnMain(): Flowable<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Single<T>.performOnBackgroundOutputOnMain(): Single<T> {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun Completable.performOnBackgroundOutputOnMain(): Completable {
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}