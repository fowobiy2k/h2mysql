//package com.fowobi.h2mysql.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
//import org.springframework.boot.sql.init.DatabaseInitializationMode;
//import org.springframework.boot.sql.init.DatabaseInitializationSettings;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration( proxyBeanMethods = false)
//public class DatasourceConfig {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "app.datasource.primary")
//    public DataSourceProperties pryDBProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean( name = "primary" )
//    @Primary
//    public HikariDataSource pryDB(DataSourceProperties pryDBProperties) {
//        return pryDBProperties.initializeDataSourceBuilder()
//                .type(HikariDataSource.class)
//                .build();
//    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "app.datasource.secondary")
//    public DataSourceProperties secDBProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean( name = "secondary")
//    public DataSource secDB(@Qualifier("secDBProperties") DataSourceProperties secDBProperties) {
//        return DataSourceBuilder
//                .create()
//                .url(secDBProperties.getUrl())
//                .username(secDBProperties.getUsername())
//                .password(secDBProperties.getPassword())
//                .build();
//    }
//
////    @Bean
////    DataSourceScriptDatabaseInitializer secDBInitializer(@Qualifier("secondary") DataSource dataSource) {
////        var settings = new DatabaseInitializationSettings();
////        List<String> paths = new ArrayList<>();
////        paths.add("classpath:secDb-schema.sql");
////        settings.setSchemaLocations(paths);
////        settings.setMode(DatabaseInitializationMode.ALWAYS);
////
////        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
////    }
//
//}
