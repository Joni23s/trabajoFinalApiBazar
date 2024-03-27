package com.joni23s.finalWorkApiMarket.repositories;

import com.joni23s.finalWorkApiMarket.entities.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long> {

}
