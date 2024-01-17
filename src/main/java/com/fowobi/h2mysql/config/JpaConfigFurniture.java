package com.fowobi.h2mysql.config;

import com.fowobi.h2mysql.model.Furniture;
import com.fowobi.h2mysql.model.Phone;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.fowobi.h2mysql.repository.furniture",
        entityManagerFactoryRef = "furnitureEntityManagerFactory",
        transactionManagerRef = "furnitureTransactionManager"
)
public class JpaConfigFurniture {

    @Bean( name = "furnitureDatasource")
    @ConfigurationProperties(prefix = "app.datasource.secondary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean( name = "furnitureEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean furnitureEntityManagerFactory(
            @Qualifier("furnitureDatasource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages(Furniture.class)
                .build();
    }

    @Bean( name = "furnitureTransactionManager")
    public PlatformTransactionManager furnitureTransactionManager(
            @Qualifier("furnitureEntityManagerFactory") EntityManagerFactory furnitureEntityManagerFactory) {
        return new JpaTransactionManager(furnitureEntityManagerFactory);
    }

}
