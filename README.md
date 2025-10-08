curl -X POST http://localhost:8080/api/cart/add \
-H "Content-Type: application/json" \
-d '{
"id": 1,
"name": "Laptop",
"price": 999.99,
"quantity": 1
}'

curl -X POST http://localhost:8080/api/cart/add \
-H "Content-Type: application/json" \
-d '{
"id": 22,
"name": "shreddies",
"price": 5.99,
"quantity": 3
}'

curl -X GET http://localhost:8080/api/cart/view \
-H "Accept: application/json"
