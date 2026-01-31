# Adaptive Sorting Engine - Java

\# Adaptive Sorting Engine for E-Commerce (Java)



\## Overview

This project implements a realistic Adaptive Sorting Engine for an e-commerce platform.

It dynamically selects sorting logic based on user preferences stored in MongoDB

and operates on real product data stored in MySQL.



\## Tech Stack

\- Java (Core Java, JDBC)

\- MySQL (Product data storage)

\- MongoDB (User behavior \& preferences)

\- Kaggle Dataset (Amazon product data)



\## System Flow

CSV (Kaggle)

→ MySQL (raw\_amazon → products)

→ Java (fetch via JDBC)

→ AdaptiveSorter (price / rating)

→ MongoDB (user preference driven)



\## Features

\- Real-world data ingestion

\- Clean separation of data layer and business logic

\- Dynamic sorting based on user behavior

\- Extensible system design



\## Example

If MongoDB stores:

{ userId: 1, sortKey: "rating" }



The system automatically sorts products by rating

without changing application code.



\## Why This Project Matters

This project demonstrates:

\- Backend data pipelines

\- Database integration

\- Adaptive algorithms

\- Real-world system design patterns



