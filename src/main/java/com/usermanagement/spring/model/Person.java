package com.usermanagement.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="FNAME")
	private String firstName;
	
	@Column(name="LNAME")
	private String lastame;
	
	@Column(name="MNAME")
	private String middleName;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="ZIP")
	private int zipCode;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="PHONE_NUMBER")
	private int phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}
	
	public String getmiddleName() {
		return middleName;
	}

	public void setMiddleName(String name) {
		this.middleName = name;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getGender(){
		return gender;
	}
	
	public int getZipCode(){
		return zipCode;
	}
	
	public void setZipCode(int zipCode){
		this.zipCode = zipCode;
	}
	
	public void setPhoneNumber(int number){
		this.phoneNumber = number;
	}
		
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", country="+country;
	}
}
