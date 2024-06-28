package com.awilab.domain.common

import kotlinx.coroutines.flow.Flow

interface UseCase<out Output> {
    operator fun invoke(): Flow<Result<Output>>
}
