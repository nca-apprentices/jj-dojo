package dojo

import kotlin.test.Test
import kotlin.test.assertEquals

class GreetTest {
    @Test
    fun `greets by name`() {
        assertEquals("Hello, Lena!", greet("Lena"))
    }
}
