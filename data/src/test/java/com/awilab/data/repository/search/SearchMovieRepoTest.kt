package com.awilab.data.repository.search

import com.awilab.testing.di.testModules
import com.awilab.testing.extension.shouldBe
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

class SearchMovieRepoTest : KoinTest {
    private val mockWebServer: MockWebServer by inject()
    private var searchMovieRepo by Delegates.notNull<SearchMovieRepo>()

    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
        mockWebServer.startServer()
        searchMovieRepo = SearchMovieRepo(get())
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    @DisplayName("API-mock searchMovie")
    fun testAPI() = runTest {
        val resp = searchMovieRepo.searchMovie("123")

        resp.isSuccessful shouldBe true
        resp.body()?.apply {
            page shouldBe 1
            totalPages shouldBe 1
            totalResults shouldBe 3
        }
    }
}
