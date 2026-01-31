
CREATE DATABASE IF NOT EXISTS adaptive_sorting;
USE adaptive_sorting;

CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price DECIMAL(10,2),
    rating FLOAT,
    popularity INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE sorting_metrics (
    metric_id INT AUTO_INCREMENT PRIMARY KEY,
    dataset_size INT,
    data_distribution VARCHAR(50),
    algorithm_used VARCHAR(50),
    execution_time_ms DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_sort_preferences (
    preference_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    sort_key VARCHAR(50),
    sort_order VARCHAR(10),
    last_used TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
