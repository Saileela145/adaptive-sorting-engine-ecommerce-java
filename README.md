# Adaptive Sorting Engine for E-Commerce (Java)

## Overview
This project implements a realistic **Adaptive Sorting Engine** for an e-commerce platform.

It dynamically selects sorting logic based on user preferences stored in **MongoDB** and operates on real product data stored in **MySQL**.


## Tech Stack
- Java (Core Java, JDBC)
- MySQL (Product data storage)
- MongoDB (User behavior and preferences)
- Kaggle Dataset (Amazon product data)


## System Flow
CSV (Kaggle Dataset)  
→ MySQL (`raw_amazon` → `products` table)  
→ Java Application (data fetched via JDBC)  
→ Adaptive Sorter (sorting by price or rating)  
→ MongoDB (user preference–driven sorting)


## Features
- Real-world data ingestion
- Clean separation of data layer and business logic
- Dynamic sorting based on user behavior
- Extensible and modular system design


## Example
If MongoDB stores the following user preference:

```json
{
  "userId": 1,
  "sortKey": "rating"
}
