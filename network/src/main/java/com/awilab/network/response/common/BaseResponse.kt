package com.awilab.network.response.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

// TODO: Need to modeling response: https://proandroiddev.com/modeling-retrofit-responses-with-sealed-classes-and-coroutines-9d6302077dfe

sealed interface BaseResponse<out T> {
    data class Success<T>(val data: T) : BaseResponse<T>
    data class Error(val exception: Throwable) : BaseResponse<Nothing>
    data object Loading : BaseResponse<Nothing>
}

fun <T> Flow<T>.asBaseResponse(): Flow<BaseResponse<T>> {
    return this
        .map<T, BaseResponse<T>> { data -> BaseResponse.Success(data = data) }
        .onStart { emit(BaseResponse.Loading) }
        .catch { exception -> emit(BaseResponse.Error(exception = exception)) }
}
