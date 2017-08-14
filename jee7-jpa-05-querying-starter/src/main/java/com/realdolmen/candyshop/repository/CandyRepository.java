package com.realdolmen.candyshop.repository;

import com.realdolmen.candyshop.domain.Candy;
import com.realdolmen.candyshop.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CandyRepository {
    EntityManager em;

    public double findAverageCandyPrice() {
        Query q = em.createQuery("select avg(c.price) from Candy c");
        return (double) q.getSingleResult();
    }

    public List<Candy> findCandyByNameLike(String name) {
        Query q = em.createQuery("select c from Candy c where c.name LIKE :name");
        q.setParameter("name", "%" + name + "%");
        return q.getResultList();
    }

    public List<Candy> findUniqueCandyForPersonOrderHistory(Person p) {
        TypedQuery<Candy> q = em.createQuery("select distinct ol.candy from Person p join p.orderHistory o join o.orderLines ol where p.id = :id order by ol.candy.name", Candy.class);
        q.setParameter("id", p.getId());
        return q.getResultList();
    }
}
