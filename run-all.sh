set -e

services=(
  "discovery-server"
  "api-gateway"
  "user-service"
  "driver-service"
  "ride-service"
  "payment-service"
  "matching-service"
  "tracking-service"
  "notification-service"
)

for svc in "${services[@]}"; do
  echo "🚀 Starting $svc..."
  (cd services/$svc && mvn spring-boot:run) &
  sleep 5
done

echo "✅ All services started. API Gateway at http://localhost:8080"
