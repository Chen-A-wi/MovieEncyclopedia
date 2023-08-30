package com.awilab.data.repository.search

import com.awilab.common.QueryType.MOVIE
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

class SearchTMDBRepoTest : KoinTest {
    private val mockWebServer: MockWebServer by inject()
    private var searchTMDBRepo by Delegates.notNull<SearchTMDBRepo>()

    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
        mockWebServer.startServer()
        searchTMDBRepo = SearchTMDBRepo(get())
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @Test
    @DisplayName("API-mock searchMovie")
    fun testSearchMovieAPI() = runTest {
        val resp = searchTMDBRepo.searchTMDB(MOVIE, "Jack")

        resp.isSuccessful shouldBe true
        resp.body()?.apply {
            page shouldBe 1
            totalPages shouldBe 1
            totalResults shouldBe 3
        }
    }
}
