package org.example.cart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppingCartApplication {
    companion object
}

fun main(args: Array<String>) {
    runApplication<ShoppingCartApplication>(*args)
}
