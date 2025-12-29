# Build stage
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /build

COPY Main.java .

RUN javac -d out Main.java \
 && jar --create --file app.jar --main-class Main -C out .

# Runtime stage
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=builder /build/app.jar app.jar

# Create data directory and multi-line file
RUN mkdir -p /data && cat > /data/bank-data-simple.csv <<'EOF'
30-01-2017,-100,Deliveroo
30-01-2017,-50,Tesco
01-02-2017,6000,Salary
02-02-2017,2000,Royalties
02-02-2017,-4000,Rent
03-02-2017,3000,Tesco
05-02-2017,-30,Cinema
EOF

ENTRYPOINT ["java", "-jar", "app.jar"]
