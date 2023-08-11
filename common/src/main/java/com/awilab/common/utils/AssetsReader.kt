package com.awilab.common.utils

interface AssetsReader {
    fun getFileFromAssets(assetsPath: String): String
}
