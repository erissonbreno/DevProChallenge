# Logger and Inventory Management

## Overview
This project includes two tasks:

1. **Logger**: A utility for logging messages to a file with timestamps and severity levels.
2. **Inventory Management**: A system to sort a list of products based on various criteria.

---

## Logger

### Description
The `Logger` class writes log messages to a specified file in the `resources/logs` directory.

### Features
- Automatically creates the logs directory if it doesn’t exist.
- Supports multiple severity levels (`INFO`, `WARNING`, `ERROR`).
- Appends log entries to the specified file.

### Example Usage
```java
Logger logger = new Logger("src/main/resources/logs");
logger.logMessage("application.log", "User logged in", "INFO");
```

### Output Example in `application.log`
```
[2025-01-14 10:20:30] [INFO] User logged in
```

### Tests
Test cases are implemented using JUnit. Example scenarios:
- Append log entry to file

---

## Inventory Management

### Description
The `InventoryManagement` class provides functionality to sort a list of products based on a given key (`name`, `price`, or `stock`) and order (ascending or descending).

### Features
- Sorts by:
    - **Name** 
    - **Price** 
    - **Stock** 
- Supports ascending and descending order.

### Example Usage
```java
List<Product> products = new ArrayList<>();
products.add(new Product("Product A", 100, 5));
products.add(new Product("Product B", 200, 3));
products.add(new Product("Product C", 50, 10));

List<Product> sortedProducts = InventoryManagement.sortInventory(products, "price", false);
sortedProducts.forEach(System.out::println);
```

### Output Example
```
{name='Product B', price=200.00, stock=3}
{name='Product A', price=100.00, stock=5}
{name='Product C', price=50.00, stock=10}
```

---

## Directory Structure
```
project-root/
│
├── src
│   ├── main/java
│   │   ├── domain
│   │       ├── Logger.java
│   │       ├── InventoryManagement.java
│   │       ├── Product.java
│   │  ├── model
│   │       ├── LogLevelModel.java 
│   ├── resources/
│   │   ├── logs/
│   │       ├── application.log
├── test/java
│   ├── LoggerTest.java
│
```

---

## How to Run
1. Compile the Java classes
2. Execute the `main` method in `Logger` or `Inventory`.
3. Run tests using JUnit to validate functionality.

---

