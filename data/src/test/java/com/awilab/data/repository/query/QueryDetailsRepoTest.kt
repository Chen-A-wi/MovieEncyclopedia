package com.awilab.data.repository.query

import com.awilab.testing.di.testModules
import com.awilab.testing.extension.startServer
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockWebServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import org.koin.test.inject
import kotlin.properties.Delegates

class QueryDetailsRepoTest : KoinTest {
    private val mockWebServer: MockWebServer by inject()
    private var queryDetailsRepo by Delegates.notNull<QueryDetailsRepo>()

    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
        mockWebServer.startServer()
        queryDetailsRepo = QueryDetailsRepo(get())
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    @DisplayName("API-mock queryDetails")
    fun testQueryDetailsAPI() = runTest {
    }
}
