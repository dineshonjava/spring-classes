/**
 * 
 */
package com.doj.webapp.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.doj.webapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RestClient restClient = applicationContext.getBean(RestClient.class);
		Account account = restClient.findAccount(1000l, "http://localhost:8080/26-Spring-REST/accounts/1000");
		System.out.println(account);
		List<Account> accounts = restClient.findAllAccount("http://localhost:8080/26-Spring-REST/all-accounts");
		System.out.println(accounts);
		applicationContext.close();*/
		//AsyncRestTemplate restTemplate = new AsyncRestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/accounts/1000", Account.class);
		System.out.println(account);
		List<Account>  accounts = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/all-accounts", List.class);
		System.out.println(accounts);
		//restTemplate.delete("http://localhost:8080/26-Spring-REST/accounts/1000");
		account = new Account(5000l);
		account.setBalance(459553l);
		account.setName("Arnav");
		restTemplate.postForLocation("http://localhost:8080/26-Spring-REST/open-account", account);
		accounts = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/all-accounts", List.class);
		System.out.println(account);
		System.out.println(accounts);
		account = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/accounts/5000", Account.class);
		account.setName("Arnav Rajput");
		restTemplate.put("http://localhost:8080/26-Spring-REST/accounts/5000", account);
		accounts = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/all-accounts", List.class);
		System.out.println(accounts);
	}

}
