/**
 * 
 */
package com.doj.webapp.web.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doj.webapp.model.User;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController //As of Spring 4.0 //RestController = Controller+Response Body
public class HomeController {
	
	@GetMapping("/") //As of Spring 4.3
	public String home (){
		return "Welcome to DOJ classes";
	}
	
	@GetMapping("/create")
	public String create (){
		return "addUser";
	}
	
	//@RequestMapping(value = "/create", method = RequestMethod.POST)
	@PostMapping("/create")
	public String saveUser ( User user, ModelMap model){
		model.put("user", user);
		return "addUser";
	}
}

//JSON-converts to User Java object- Done by Request Body
