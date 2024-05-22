package com.awilab.data.repository.search

import com.awilab.domain.repository.SearchRepository
import com.awilab.network.response.common.Result
import com.awilab.network.response.common.asResult
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

class SearchRepositoryTest : KoinTest {
    private val mockWebServer: MockWebServer by inject()
    private var repository by Delegates.notNull<SearchRepository>()

    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
        mockWebServer.startServer()
        repository = SearchRepositoryImpl(get())
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    @DisplayName("Search movie success")
    fun testSearchMovie() = runTest {
        repository.searchMovies(
            query = "test",
            page = 1,
            language = "en",
        ).asResult().collect { result ->
            when (result) {
                is Result.Error -> {
                }

                Result.Loading -> {
                }

                is Result.Success -> {
                    result.data.apply {
                        page shouldBe 1
                        totalPages shouldBe 1
                        totalResults shouldBe 3
                        results.size shouldBe 3
                    }
                }
            }
        }
    }
}
