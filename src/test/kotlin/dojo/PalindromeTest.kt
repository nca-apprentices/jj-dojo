package dojo

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeTest {
    @Test
    fun detectsPalindrome() {
        assertTrue(isPalindrome("Anna"))
    }

    @Test
    fun rejectsNonPalindrome() {
        assertFalse(isPalindrome("Kotlin"))
    }

    @Test
    fun emptyStringIsPalindrome() {
        assertTrue(isPalindrome(""))
    }
}
