package dojo

import kotlin.test.Test
import kotlin.test.assertEquals

class GreetTest {
    @Test
    fun `greets by name`() {
        assertEquals("Hello, Lena!", greet("Lena"))
    }

    @Test
    fun `says goodbye by name`() {
        assertEquals("Goodbye, Lena!", farewell("Lena"))
    }
}
