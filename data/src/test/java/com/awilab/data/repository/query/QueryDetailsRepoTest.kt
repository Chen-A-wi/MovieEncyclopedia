package com.awilab.data.repository.query

import com.awilab.testing.di.testModules
import com.awilab.testing.extension.startServer
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

class QueryDetailsRepoTest : KoinTest {
    private val mockWebServer: MockWebServer by inject()

    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
        mockWebServer.startServer()
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }
}
