package com.sa.logging.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.sa.logging.model.Logging;

public interface LoggingRepository extends CassandraRepository<Logging, UUID> {
    @AllowFiltering
    List<Logging> findByPublished(boolean published);

    List<Logging> findByTitleContaining(String title);
}