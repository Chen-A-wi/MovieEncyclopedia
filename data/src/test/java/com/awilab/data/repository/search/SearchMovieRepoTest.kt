package com.awilab.data.repository.search

import com.awilab.testing.di.testModules
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class SearchMovieRepoTest {
    @BeforeEach
    fun setup() {
        startKoin {
            modules(testModules)
        }
    }

    @AfterEach
    fun tearDown() {
        stopKoin()
    }

    @Test
    @DisplayName("API測試")
    fun testAPI() {
    }
}
