package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonRepository {
    EntityManager em;


    public Person findPersonById(long id) {
        TypedQuery<Person> query = em.createNamedQuery(Person.FIND_PERSON_BY_ID, Person.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Person> findAllPeople() {
        TypedQuery<Person> query = em.createNamedQuery(Person.FIND_ALL_PEOPLE, Person.class);
        return query.getResultList();
    }

    public void savePerson(Person p) {
        em.persist(p);
    }

    public void deletePersonById(long id) {
        em.remove(em.find(Person.class, id));
    }

    public void updatePerson(Person p) {
        em.merge(p);
    }

    public long countAllPeople() {
        Query q = em.createNamedQuery(Person.COUNT_ALL_PEOPLE);
        return (Long) q.getSingleResult();
    }

}
