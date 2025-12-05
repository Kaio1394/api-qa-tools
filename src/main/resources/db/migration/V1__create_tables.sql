CREATE TABLE test_results (
    id UUID PRIMARY KEY,
    ticket VARCHAR(255),
    status VARCHAR(50) NOT NULL
);

CREATE TABLE variables (
    id UUID PRIMARY KEY
);