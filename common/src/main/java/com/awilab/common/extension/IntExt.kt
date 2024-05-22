package com.awilab.common.extension

fun Int?.orZero(): Int = this ?: 0

fun Double?.orZero(): Double = this ?: 0.0
