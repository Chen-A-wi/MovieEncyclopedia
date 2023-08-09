package com.awilab.network.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResp<T>(
    @SerialName("success")
    val isSuccess: Boolean,
    val data: T,
)
