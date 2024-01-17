package com.fowobi.h2mysql.config;

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

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.fowobi.h2mysql.repository.phone",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "phoneTransactionManager"
)
public class JpaConfigPhone {

    @Bean( name = "datasource")
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.primary")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean( name = "entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean furnitureEntityManagerFactory(
            @Qualifier("datasource") DataSource dataSource,
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages(Phone.class)
                .build();
    }

    @Bean( name = "phoneTransactionManager")
    @Primary
    public PlatformTransactionManager phoneTransactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory furnitureEntityManagerFactory) {
        return new JpaTransactionManager(furnitureEntityManagerFactory);
    }

}
