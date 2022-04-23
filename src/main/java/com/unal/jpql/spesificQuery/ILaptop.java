package com.unal.jpql.spesificQuery;

import java.util.List;

public interface ILaptop{

    // kendi query yapımız olusturdugumuz yer
    public List<Laptop> findMin(double price);

}
