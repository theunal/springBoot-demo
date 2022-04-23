package com.unal.jpql.spesificQuery;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class LaptopImp implements ILaptop{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Laptop> findMin(double price) {
        String jpql = "select lap from Laptop lap where lap.laptopPrice>=:key";
        TypedQuery<Laptop> query =  manager.createQuery(jpql,Laptop.class);
        query.setParameter("key",price);
        return query.getResultList();

    }
}
