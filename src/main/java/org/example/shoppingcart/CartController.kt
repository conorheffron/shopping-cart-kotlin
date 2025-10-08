package com.example.shoppingcart

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/cart")
class CartController {

    private val cart = mutableListOf<CartItem>()

    // Add item to the cart
    @PostMapping("/add")
    fun addItemToCart(@RequestBody item: CartItem): String {
        cart.add(item)
        return "Item '${item.name}' added to the cart."
    }

    // View all items in the cart
    @GetMapping("/view")
    fun viewCart(): List<CartItem> {
        return cart
    }
}