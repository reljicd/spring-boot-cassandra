FROM cassandra:3.11

# replace Docker's official entrypoint here
COPY docker/cassandra/docker-entrypoint.sh /docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh

COPY docker/cassandra/initial-seed.cql docker-entrypoint-initdb.d/initial-seed.cql