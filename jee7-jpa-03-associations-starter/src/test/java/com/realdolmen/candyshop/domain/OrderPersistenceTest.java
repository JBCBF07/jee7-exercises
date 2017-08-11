package com.realdolmen.candyshop.domain;

import com.realdolmen.candyshop.AbstractPersistenceTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class OrderPersistenceTest extends AbstractPersistenceTest {
    @Test
    public void orderCanBePersisted() throws Exception {
        Order o = new Order();
        o.setDeliveryAddress(new Address("Kattenberg", "7", "Huizingen", "2574"));
        em.persist(o);
        assertNotNull(o.getId());
    }

    @Test
    public void orderCanBeLoaded() throws Exception {
        Order order = em.find(Order.class, 2000L);
        assertEquals("Manhattan 13 1078 Geel", order.getDeliveryAddress().toString());
    }

    @Test
    public void orderCanHavePerson() throws Exception {
        Person p = em.find(Person.class, 3000L);
        Order o = new Order();
        o.setPerson(p);
        em.persist(o);
        em.flush();
        em.clear();

        Order po = em.find(Order.class, o.getId());
        assertEquals("Tyler", po.getPerson().getFirstName());
    }

    @Test
    public void orderHasOrderLines() throws Exception {
        Order o = em.find(Order.class, 1000L);
        List<OrderLine> orderLines = o.getOrderLines();
        assertEquals(3, orderLines.size());
    }

    @Test
    public void orderLinesFromOrderHaveCandy() throws Exception {
        Order o = em.find(Order.class, 3000L);
        OrderLine ol = o.getOrderLines().get(0);
        assertEquals("Sweethearts", ol.getCandy().getName());
    }

    @Test
    public void orderCanAddOrderLine() throws Exception {
        Order o = em.find(Order.class, 3000L);
        int beginLines = o.getOrderLines().size();
        o.getOrderLines().add(new OrderLine());

        em.persist(o);

        Order p = em.find(Order.class, o.getId());
        assertEquals(p.getOrderLines().size(), beginLines + 1 );
    }

    @Test
    public void orderCanCalculateTotalPrice() throws Exception {
        Order o = new Order();

        o.setOrderLines(
                Arrays.asList(
                        new OrderLine(
                                2,
                                new Candy(
                                        "a",
                                        5,
                                        CandyColor.BLUE
                                )
                        ),
                        new OrderLine(
                                2,
                                new Candy(
                                        "b",
                                        5,
                                        CandyColor.RED
                                )
                        )
                )
        );

        double total = o.calculateTotal();

        assertEquals(20, total, 0.01);


    }
}
