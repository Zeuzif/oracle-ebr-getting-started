package me.wassif.ebr.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class OracleConfiguration {
	Logger log = LoggerFactory.getLogger(OracleConfiguration.class);

	@Bean
	@Primary
	protected DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUsername("wassif");
		dataSource.setPassword("wassif");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/XEPDB1");

		Properties properties = new Properties();
		properties.setProperty("oracle.jdbc.editionName", "release1");
		dataSource.setConnectionProperties(properties);

		log.info("dataSource:{}", dataSource);
		return dataSource;
	}
}
