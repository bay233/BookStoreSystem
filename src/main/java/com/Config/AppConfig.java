package com.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com")
@EnableTransactionManagement   //事务管理配置
public class AppConfig {

	@Bean
	public DriverManagerDataSource DataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bss?serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("a");
		return dataSource;
	}
	
	
	/**
	 * 事务管理配置
	 * @param ds  指定数据源
	 * @return
	 */
	@Bean
	@Autowired
	public DataSourceTransactionManager ts(DriverManagerDataSource ds){
		DataSourceTransactionManager dtm = new DataSourceTransactionManager();
		dtm.setDataSource(ds);
		return dtm;
	}

}

