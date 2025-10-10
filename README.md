# shopping-cart-kotlin

[![Android CI](https://github.com/conorheffron/shopping-cart-kotlin/actions/workflows/android.yml/badge.svg)](https://github.com/conorheffron/shopping-cart-kotlin/actions/workflows/android.yml)

[![SonarQube Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=conorheffron_shopping-cart-kotlin)](https://sonarcloud.io/summary/new_code?id=conorheffron_shopping-cart-kotlin)

[Sonar Scan & Test Coverage - Overall Summary](https://sonarcloud.io/summary/overall?id=conorheffron_shopping-cart-kotlin&branch=main)

### Tech
 - JDK 17, Gradle 8, Kotlin 2.2.20, Spring Boot 3, JaCoCo, Kover, SonarQube

### Build Project & Run Tests
```
./gradlew clean build test
```

### Run API App main() directly
```
src/main/java/org/example/cart/ShoppingCartApplicationKt
```
  ##### OR
```
./gradlew bootRun
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

Item 'Laptop' added to the cart.%  
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

[{"id":1,"name":"Laptop","price":999.99,"quantity":1},{"id":22,"name":"shreddies","price":5.99,"quantity":3}]%      
```
