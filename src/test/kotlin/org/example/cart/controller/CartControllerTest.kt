package org.example.cart.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class CartControllerTest {

    private val cartController = CartController()
    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(cartController).build()

    @Test
    fun `addItemToCart should add item to cart and return success message`() {
        // Arrange
        val cartItemJson = """{"id": 7, "name": "Apple", "quantity": 3, "price": 3.99}"""

        // Act & Assert
        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/cart/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cartItemJson)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("Item 'Apple' added to the cart."))

        // Verify the cart contains the item
        val cart = cartController.viewCart()
        Assertions.assertEquals(1, cart.size)
        Assertions.assertEquals("Apple", cart[0].name)
        Assertions.assertEquals(3, cart[0].quantity)
        Assertions.assertEquals(7, cart[0].id)
        Assertions.assertEquals(3.99, cart[0].price)
    }

    @Test
    fun `view should add item to cart and return success message`() {
        // Act & Assert
        mockMvc.perform(
            MockMvcRequestBuilders.get("/api/cart/view")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("[]"))

        // Verify the cart contains the item
        val cart = cartController.viewCart()
        Assertions.assertEquals(0, cart.size)
    }
}
