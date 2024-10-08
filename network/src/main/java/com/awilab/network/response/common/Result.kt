package com.awilab.network.response.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

// Modeling response: https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe
sealed interface Result<out T> {
    data class Success<T>(val data: T) :
        Result<T>
    data class Error(val exception: Throwable) :
        Result<Nothing>
    data object Loading : Result<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        .map<T, Result<T>> { data -> Result.Success(data = data) }
        .onStart { emit(Result.Loading) }
        .catch { exception -> emit(Result.Error(exception = exception)) }
}
