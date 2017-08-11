package com.realdolmen.candyshop.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQuery(name="findPersonJoris", query="SELECT p FROM Person p WHERE p.firstName='Joris' AND p.lastName='Boschmans'")
public class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	
	
	public Person(){}
	
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
