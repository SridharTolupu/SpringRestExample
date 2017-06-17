package com.usermanagement.spring.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import com.usermanagement.spring.model.Person;

public class UserControllerDAO {
	
	 String sql = "CREATE TABLE PERSON (\n"
             + "	id integer PRIMARY KEY,\n"
             + "	name varchar(30) NOT NULL,\n"
             + "	country varchar(30)\n"
             + ");";

	public UserControllerDAO(){
		System.out.println("UserControllerDAO");
	}
	
	private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    private boolean sessionExist = false;
    
    public void save(Person p) {
		Session session = getSession();    	
		Transaction tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
		session.close();
	}
    
    public List<Person> getAllusers(){
    	Session session = getSession();  
		List<Person> userList = session.createQuery("from Person").list();

		return userList;
    }
	
    public void createUserTable() {
    	Session session = getSession();  
		Transaction tx = session.beginTransaction();
		session.createSQLQuery(sql);
		tx.commit();
    }
    
private Session getSession(){
	if(!sessionExist){
		sessionExist= true;
		return this.sessionFactory.openSession();
	 
	}
	else
	{
		return this.sessionFactory.getCurrentSession();
	}
}
}
