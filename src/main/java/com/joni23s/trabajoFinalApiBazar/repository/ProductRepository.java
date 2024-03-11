package com.joni23s.trabajoFinalApiBazar.repository;

import com.joni23s.trabajoFinalApiBazar.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Long> {

    public List<ProductEntity> findAll();
}
