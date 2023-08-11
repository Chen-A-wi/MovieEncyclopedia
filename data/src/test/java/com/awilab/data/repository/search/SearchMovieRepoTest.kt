package com.awilab.data.repository.search

import com.awilab.testing.di.testModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
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
        mockWebServer.start()
        searchMovieRepo = SearchMovieRepo(get())
    }

    @AfterEach
    fun tearDown() {
        mockWebServer.shutdown()
        stopKoin()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @DisplayName("API測試")
    fun testAPI() = runTest {
        launch {
            val resp = searchMovieRepo.searchMovie("Jack+Reacher")
            println(resp.body().toString())
        }
    }
}
