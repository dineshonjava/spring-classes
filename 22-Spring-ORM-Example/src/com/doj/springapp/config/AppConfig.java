/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages={"com.doj.springapp.repository", "com.doj.springapp.service"})//implicity bean creation
@Import({InfrastructureConfig.class, SecurityConfig.class})
public class AppConfig {
	
}
