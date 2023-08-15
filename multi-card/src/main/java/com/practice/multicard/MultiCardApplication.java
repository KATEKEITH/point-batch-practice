package com.practice.multicard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EntityScan("com.multi.multi-core")
// @SpringBootApplication(scanBasePackages = { "com.multi" })
@SpringBootApplication
public class MultiCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiCardApplication.class, args);
	}

	// @Primary
	// @Bean
	// @ConfigurationProperties("spring.datasource.hikari")
	// public HikariDataSource dataSource() {
	// return DataSourceBuilder.create().type(HikariDataSource.class).build();
	// }

	// @Bean
	// @ConfigurationProperties("userlock.datasource.hikari")
	// public HikariDataSource userLockDataSource() {
	// return DataSourceBuilder.create().type(HikariDataSource.class).build();
	// }

	// @Bean
	// public UserLevelLockWithJdbcTemplate userLevelLockWithJdbcTemplate() {
	// return new UserLevelLockWithJdbcTemplate(new
	// NamedParameterJdbcTemplate(dataSource()));
	// }

	// @Bean
	// public UserLevelLockFinal userLevelLockFinal() {
	// return new UserLevelLockFinal(dataSource());
	// }

}
