package io.codekaffee.pocs.jdbipoc.config;

import io.codekaffee.pocs.jdbipoc.domain.models.Movie;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.jdbi.v3.core.statement.HashPrefixSqlParser;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JdbiConfig {
    
    
    @Bean
    public Jdbi instantiateJdbi(DataSource dataSource) {
        TransactionAwareDataSourceProxy dataSourceProxy =  new TransactionAwareDataSourceProxy(dataSource);
        
        Jdbi jdbi =  Jdbi.create(dataSourceProxy);


        jdbi.setSqlParser(new HashPrefixSqlParser());

        jdbi.installPlugin(new PostgresPlugin());
        jdbi.installPlugin(new SqlObjectPlugin());
        
        return jdbi;
    }
}