package com.awilab.network

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Serializable
    data class Project(val name: String, val language: String)

    @Test
    @DisplayName("Json轉換")
    fun testJson() {
        val data = Project("kotlinx.serialization", "Kotlin")
        val string = Json.encodeToString(data)
        println(string) // {"name":"kotlinx.serialization","language":"Kotlin"}
        // Deserializing back into objects
        val obj = Json.decodeFromString<Project>(string)
        println(obj) // Project(name=kotlinx.serialization, language=Kotlin)

        assertEquals(obj.language, "Kotlin")
    }
}
