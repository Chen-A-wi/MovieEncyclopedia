package com.awilab.testing.extension

import com.awilab.common.configs.CommonConfig
import okhttp3.mockwebserver.MockWebServer

fun MockWebServer.startServer() {
    CommonConfig.isMock = true
    start()
    CommonConfig.MOCK_API_URL = "http://$hostName:$port/"
}
