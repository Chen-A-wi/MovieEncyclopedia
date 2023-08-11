package com.awilab.testing.utils

import com.awilab.common.utils.AssetsReader
import java.io.BufferedReader
import java.io.InputStreamReader

class TestAssetsReaderImpl : AssetsReader {
    override fun getFileFromAssets(assetsPath: String): String {
        val builder = StringBuilder()
        val reader = BufferedReader(
            InputStreamReader(
                javaClass.classLoader?.getResourceAsStream(assetsPath),
            ),
        )

        var theCharNum = reader.read()
        while (theCharNum != -1) {
            builder.append(theCharNum.toChar())
            theCharNum = reader.read()
        }

        return builder.toString()
    }
}
