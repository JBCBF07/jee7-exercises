package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.validation.constraints.AssertTrue;

// TODO: use the AbstractPersistence Test
public class PersonPersistenceTest extends AbstractPersistenceTest {
    // TODO: add unit test personCanBePersisted()
	@Test
	public void personCanBePersisted(){
		initializeEntityManagerFactory();
		initializeEntityManagerWithTransaction();
		Person p = new Person("Joris", "Boschmans");
		em.persist(p);
		tx.commit();
		assertNotNull(p.getId());
	}
    // TODO: add unit test personCanBeLoaded()
	
	@Test
	public void personCanBeLoaded(){
		Person p = em.createNamedQuery("findPersonJoris", Person.class).getSingleResult();
		assertNotNull(p);
	}
}
