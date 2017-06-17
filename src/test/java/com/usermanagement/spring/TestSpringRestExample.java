package com.usermanagement.spring;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.usermanagement.spring.controller.UserRestURIConstants;
import com.usermanagement.spring.model.Person;

public class TestSpringRestExample {

	public static final String SERVER_URI = "http://localhost:9090/SpringRestExample";
	
	public static void main(String args[]){
		
		testGetDummyUser();
		System.out.println("*****");
		testCreateUser();
		System.out.println("*****");
		testGetUser();
		System.out.println("*****");
		testGetAllUsers();
	}

	private static void testGetAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Person> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		List<LinkedHashMap> users = restTemplate.getForObject(SERVER_URI+UserRestURIConstants.GET_ALL_USER, List.class);
		System.out.println(users.size());
		for(LinkedHashMap map : users){
			System.out.println("ID="+map.get("id")+",Name="+map.get("firstName")+",CreatedDate="+map.get("createdDate"));;
		}
	}

	private static void testCreateUser() {
		RestTemplate restTemplate = new RestTemplate();
		Person user = new Person();
		user.setId(1);user.setFirstName("Sridhar");
		Person response = restTemplate.postForObject(SERVER_URI+UserRestURIConstants.CREATE_USER, user, Person.class);
		printUserData(response);
	}

	private static void testGetUser() {
		RestTemplate restTemplate = new RestTemplate();
		Person user = restTemplate.getForObject(SERVER_URI+"/rest/user/1", Person.class);
		printUserData(user);
	}

	private static void testGetDummyUser() {
		RestTemplate restTemplate = new RestTemplate();
		Person user = restTemplate.getForObject(SERVER_URI+UserRestURIConstants.DUMMY_USER, Person.class);
		printUserData(user);
	}
	
	public static void printUserData(Person user){
		System.out.println("ID="+user.getId()+",Name="+user.getFirstName()+",CreatedDate="+user.getCreatedDate());
	}
}
