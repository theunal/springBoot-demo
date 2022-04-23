package com.unal.jpql.pagingAndSorting;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagingSorting
        extends PagingAndSortingRepository<PagingSorting,Long> {
}

// ödev teacher sorting olacak tüm adımlar olacak ad soyad yas olacak
// ui kısmıda olacak