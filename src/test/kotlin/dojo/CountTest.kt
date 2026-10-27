package dojo

import kotlin.test.Test
import kotlin.test.assertEquals

class CountTest {
    @Test
    fun countsBackwardsFromThree() {
        assertEquals(listOf(3, 2, 1), count())
    }
}
