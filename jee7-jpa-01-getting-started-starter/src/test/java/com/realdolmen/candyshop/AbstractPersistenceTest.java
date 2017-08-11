package com.realdolmen.candyshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AbstractPersistenceTest {
    private static EntityManagerFactory emf;

    protected EntityManager em;
    protected EntityTransaction tx ;

    @BeforeClass
    public static void initializeEntityManagerFactory() {
        // TODO: initialize the EntityManagerFactory
    	if (emf == null) emf = Persistence.createEntityManagerFactory("CandyShopPersistenceUnit");
    	
    }

    @Before
    public void initializeEntityManagerWithTransaction() {
        // TODO: initialize the entity manager from the entity manager factory here
    	em = emf.createEntityManager();
        // TODO: begin a transaction
    	tx = em.getTransaction();
    	tx.begin();
    	}

    @After
    public void rollbackTransactionAndCloseEntityManager() {
        // TODO: rollback the transaction
    	// tx.rollback();
        // TODO: close the entity manager
    	em.close();
    }

    @AfterClass
    public static void destroyEntityManagerFactory() {
        // TODO; close the EntityManagerFactory
    	emf.close();
    }
}
