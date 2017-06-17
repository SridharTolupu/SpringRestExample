package com.usermanagement.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.usermanagement.spring.model.Person;

/**
 * Handles requests for the Person service.
 */
@Controller
public class PersonController {
	
	
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	@Qualifier("userControllerDAO")
	private UserControllerDAO userControllerDAO;

	Map<Integer, Person> userData = new HashMap<Integer, Person>();
	
	@RequestMapping(value = UserRestURIConstants.DUMMY_USER, method = RequestMethod.GET)
	public @ResponseBody Person getDummyPerson() {
		
		userControllerDAO.createUserTable();
		return null;
	}
	
	@RequestMapping(value = UserRestURIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody Person getPerson(@PathVariable("id") int userId) {
		
		logger.info("Start getPerson. ID="+userId);
		
		return userData.get(userId);
	}
	
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<Person> getAllPersons() {
		logger.info("Start getAllPersons.");
		List<Person> users =userControllerDAO.getAllusers();		
		return users;
	}
	
	@RequestMapping(value = UserRestURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody Person createPerson(@RequestBody Person user) {
		logger.info("Start createPerson.");
		Person p = new Person();
		p.setId(1);
		p.setZipCode(user.getZipCode());
		p.setFirstName(user.getFirstName());
		userControllerDAO.save(p);
		return user;
	}
	
	@RequestMapping(value = UserRestURIConstants.DELETE_USER, method = RequestMethod.PUT)
	public @ResponseBody Person deletePerson(@PathVariable("id") int userId) {
		logger.info("Start deletePerson.");
		Person person = userData.get(userId);
		userData.remove(userId);
		return person;
	}
	
	public UserControllerDAO getUserControllerDAO() {
		return userControllerDAO;
	}

	public void setUserControllerDAO(UserControllerDAO userControllerDAO) {
		this.userControllerDAO = userControllerDAO;
	}

}
