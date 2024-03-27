package com.joni23s.finalWorkApiMarket.repositories;

import com.joni23s.finalWorkApiMarket.entities.ProductEntity;
import com.joni23s.finalWorkApiMarket.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <ProductEntity, Long> {

    public List<ProductEntity> findAll();

}
