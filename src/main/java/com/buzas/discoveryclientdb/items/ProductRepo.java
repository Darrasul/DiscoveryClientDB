package com.buzas.discoveryclientdb.items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional(Transactional.TxType.SUPPORTS)
public interface ProductRepo extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
    @Modifying
    @Transactional(Transactional.TxType.REQUIRED)
    @Query(value = """
                delete from products p
                where p.id = :id
""", nativeQuery = true)
    void deleteById(Long id);

    @Modifying
    @Transactional(Transactional.TxType.REQUIRED)
    @Query(value = """
                insert into products(title, price)
                values (:title, :price)
""", nativeQuery = true)
    void insertNewProduct(String title, Integer price);
}
