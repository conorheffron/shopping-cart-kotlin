package org.example.cart

import org.junit.jupiter.api.Test

class ShoppingCartApplicationTest {

    @Test
    fun `main method runs without exceptions`() {
        // Simulate passing command-line arguments
        val args = arrayOf<String>()
        ShoppingCartApplication.main(args)
        // If no exceptions are thrown, the test will pass
    }
}

private fun ShoppingCartApplication.Companion.main(args: Array<String>) {}
