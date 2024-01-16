//package com.fowobi.h2mysql.config;
//
//import com.fowobi.h2mysql.model.Phone;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Objects;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackageClasses = Phone.class,
//        entityManagerFactoryRef = "phoneEntityManagerFactory",
//        transactionManagerRef = "phoneTransactionManager"
//)
//public class JpaConfig {
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean phoneEntityManagerFactory(
//            @Qualifier("secondary") DataSource dataSource,
//            EntityManagerFactoryBuilder builder) {
//        return builder
//                .dataSource(dataSource)
//                .packages(Phone.class)
//                .build();
//    }
//
//    @Bean
//    public PlatformTransactionManager todosTransactionManager(
//            @Qualifier("phoneEntityManagerFactory") LocalContainerEntityManagerFactoryBean todosEntityManagerFactory) {
//        return new JpaTransactionManager(Objects.requireNonNull(todosEntityManagerFactory.getObject()));
//    }
//
//}
