/**
 * 
 */
package com.doj.springapp.repository;

import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *jdbcAccountRepository
 */
@Repository
public class JdbcAccountRepository implements AccountRepository{
	
	@Override
	public Account findAccountById(Long id){
		return new Account(id);
	}
}
