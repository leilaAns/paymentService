package com.alithya.shoppingcart;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan({ "com.alithya.shoppingcart.repository"})
@PropertySource("classpath:/app.properties")
public class MyDataSourceConfig {

	@Autowired
	private Environment environnement;

	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(
		environnement.getProperty("jdbc.url"), environnement.getProperty("jdbc.username"),
		environnement.getProperty("jdbc.password"));
		driverManagerDataSource.setDriverClassName(environnement.getProperty("jdbc.driver"));
		return driverManagerDataSource;

	}
	
	@Bean
	public NamedParameterJdbcOperations namedPararmeterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager transactionManger() {
		return new DataSourceTransactionManager(dataSource());
	}

}
