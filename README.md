# konsumen-service
RESTFull Konsumen 

# Create a consumer
curl --location 'http://localhost:8088/api/v1/konsumens' \
--header 'Content-Type: application/json' \
--data '{
"nama": "Fulan",
"alamat": "Jl Keadilan",
"kota": "Bekasi",
"provinsi": "Jawa Barat",
"status":"actif"
}'

# Get a consumer
curl --location 'http://localhost:8088/api/v1/konsumens/1'

# Get all consumer
curl --location 'http://localhost:8088/api/v1/konsumens'

# Update a consumer
curl --location --request PUT 'http://localhost:8088/api/v1/konsumens/4' \
--header 'Content-Type: application/json' \
--data '{
"nama": "Fulan updated",
"alamat": "Jl Keadilan updated",
"kota": "Bekasi updated",
"provinsi": "Jawa Barat updated",
"status": "NON-ACTIF"
}'

# Delete a consumer
curl --location --request DELETE 'http://localhost:8088/api/v1/konsumens/4'
