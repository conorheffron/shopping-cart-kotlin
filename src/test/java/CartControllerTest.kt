import org.example.cart.controller.CartController
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

class CartControllerTest {

    private val cartController = CartController()
    private val mockMvc: MockMvc = MockMvcBuilders.standaloneSetup(cartController).build()

    @Test
    fun `addItemToCart should add item to cart and return success message`() {
        // Arrange
        val cartItemJson = """{"name": "Apple", "quantity": 3}"""

        // Act & Assert
        mockMvc.perform(
            post("/api/cart/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cartItemJson)
        )
            .andExpect(status().isOk)
            .andExpect(content().string("Item 'Apple' added to the cart."))

        // Verify the cart contains the item
        val cart = cartController.viewCart()
        assertEquals(1, cart.size)
        assertEquals("Apple", cart[0].name)
        assertEquals(3, cart[0].quantity)
    }

    @Test
    fun `view should add item to cart and return success message`() {
        // Act & Assert
        mockMvc.perform(
            get("/api/cart/view")
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andExpect(content().string("[]"))

        // Verify the cart contains the item
        val cart = cartController.viewCart()
        assertEquals(0, cart.size)
    }
}
