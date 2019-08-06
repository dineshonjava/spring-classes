/**
 * 
 */
package com.doj.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doj.webapp.dto.User;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
//@RequestMapping("/doj")
public class HelloController {
	
	//@RequestMapping(value = {"/hello", "/"}, method=RequestMethod.GET)
	/*@GetMapping(value={"/hello", "/"})
	public ModelAndView sayHello(){
		Map<String, String> model = new HashMap<>();
		model.put("message", "Welcome to DOJ classes!!!");
		return new ModelAndView("hello",model);
	}*/
	
	/*@RequestMapping(value = {"/hello", "/"}, method=RequestMethod.GET)
	public String sayHello(ModelMap model){
		model.put("message", "Welcome to DOJ classes!!!");
		return "hello";
	}*/
	/*@RequestMapping(value = {"/hello", "/"}, method=RequestMethod.GET)
	public String sayHello(ModelMap model, HttpServletRequest request){
		String name = request.getParameter("name"); //Traditional Way
		String surname = request.getParameter("surname");	
		String age = request.getParameter("age");
		model.put("message", name+" Welcome to DOJ classes!!! " +surname);
		return "hello";
	}*/
	
	/*@RequestMapping(value = {"/hello", "/"}, method=RequestMethod.GET)
	public String sayHello(ModelMap model, 
			@RequestParam(required = false, name="nm", defaultValue = "Dinesh") String name, 
			@RequestParam String surname,
			@RequestParam(required=false, defaultValue = "18") Integer age){
		model.put("message", name+" Welcome to DOJ classes!!! " +surname +" "+age);
		return "hello";
	}*/
	
	/*@RequestMapping(value = {"/{name}-{surname}"}, method=RequestMethod.GET)
	public String sayHello(ModelMap model, @PathVariable String name, @PathVariable String surname){
		model.put("message", name+" Welcome to DOJ classes!!! "+surname);
		return "hello";
	}
	*/
	@RequestMapping(value = {"/hello", "/"}, method=RequestMethod.GET)
	public String sayHello(ModelMap model, User user){
		model.put("message", user.getName()+" Welcome to DOJ classes!!! " +user.getSurname() +" "+user.getAge());
		return "hello";
	}
	
	
}
