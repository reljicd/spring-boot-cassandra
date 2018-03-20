CREATE KEYSPACE IF NOT EXISTS spring_boot_cassandra WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE spring_boot_cassandra;

CREATE TABLE example_table (
   text_field_1 TEXT,
   text_field_2 TEXT,
   int_field_1  INT,
   int_field_2  INT,
   PRIMARY KEY (text_field_1, text_field_2, int_field_1, int_field_2))
   WITH CLUSTERING ORDER BY (text_field_2 ASC, int_field_1 ASC, int_field_2 ASC);

INSERT INTO example_table (text_field_1, text_field_2, int_field_1, int_field_2)
   VALUES ('text_field_1', 'text_field_2', 1, 2);