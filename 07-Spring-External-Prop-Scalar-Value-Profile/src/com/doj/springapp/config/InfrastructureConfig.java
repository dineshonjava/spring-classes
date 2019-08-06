/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.doj.springapp.repository.AppDataSource;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@PropertySource("app-${ENV}.properties")//PropertySourcesPlaceholderConfigurer working behind
//@PropertySource("app.properties")
public class InfrastructureConfig {
 //have infrastructure related beans like DataSource, JNDI, etc.
	
	/*@Value("${dburl}") 	String dburl;
	@Value("${user}") 		String user;
	@Value("${password}") 	String password;
	@Value("${driver}") 	String driver;
	*/
	@Value("#{systemProperties['user.region']}") String abc;
	
	//String abc = System.getProperty("user.region");
	
	//One way
	@Autowired
	public Environment env;
	
	@Bean
	public AppDataSource dataSource(){
		
		AppDataSource appDataSource = new AppDataSource();
		appDataSource.setDburl(env.getProperty("dburl"));
		appDataSource.setDriver(env.getProperty("driver"));
		appDataSource.setPassword(env.getProperty("password"));
		appDataSource.setUser(env.getProperty("user"));
		return appDataSource;
	}
	
	//Second way
	/*@Bean
	public AppDataSource dataSource(
			@Value("${dburl}") String dburl, 
			@Value("${user}") String user, 
			@Value("${password}") String password, 
			@Value("${driver}") String driver){
		AppDataSource appDataSource = new AppDataSource(dburl, user, password, driver);
		return appDataSource;
	}*/
	
	/*@Bean
	public AppDataSource devDataSource(){
		AppDataSource appDataSource = new AppDataSource(dburl, user, password, driver);
		return appDataSource;
	}*/
	
	//Third Way
	/*@Bean
	@Profile("prod")
	public AppDataSource prodDataSource(
			@Value("${prod.dburl}") String dburl, 
			@Value("${prod.user}") String user, 
			@Value("${prod.password}") String password, 
			@Value("${prod.driver}") String driver){
		AppDataSource appDataSource = new AppDataSource(dburl, user, password, driver);
		return appDataSource;
	}
	
	@Bean
	@Profile("dev")
	public AppDataSource DevDataSource(
			@Value("${dev.dburl}") String dburl, 
			@Value("${dev.user}") String user, 
			@Value("${dev.password}") String password, 
			@Value("${dev.driver}") String driver){
		AppDataSource appDataSource = new AppDataSource(dburl, user, password, driver);
		return appDataSource;
	}*/
	
	//@ActivateProfile("qa")
}
