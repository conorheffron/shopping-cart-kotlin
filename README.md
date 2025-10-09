# shopping-cart-kotlin

### Build Project & Run Tests
```
./gradlew clean buil test
```

Run API App
```
src/main/java/org/example/shoppingcart/ShoppingCartApplication.kt
```

### Add Item with ID 1 via POST API Call
```
curl -X POST http://localhost:8080/api/cart/add \
-H "Content-Type: application/json" \
-d '{
"id": 1,
"name": "Laptop",
"price": 999.99,
"quantity": 1
}'
```

### Add Item with ID 22 via POST API Call
```
curl -X POST http://localhost:8080/api/cart/add \
-H "Content-Type: application/json" \
-d '{
"id": 22,
"name": "shreddies",
"price": 5.99,
"quantity": 3
}'
```
### View Carts
```
curl -X GET http://localhost:8080/api/cart/view \
-H "Accept: application/json"
```
