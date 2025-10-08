package org.example.cart.dto

data class CartItem(
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int
)