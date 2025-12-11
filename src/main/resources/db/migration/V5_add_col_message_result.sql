ALTER TABLE test_results
ADD message_result VARCHAR(255);

ALTER TABLE test_results
DROP COLUMN ticket;