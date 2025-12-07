CREATE TABLE test_results (
    id UUID PRIMARY KEY,
    tags VARCHAR(255) NOT NULL,
    ticket VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    execution_date DATE NOT NULL
);