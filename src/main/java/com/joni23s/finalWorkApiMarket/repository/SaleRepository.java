package com.joni23s.finalWorkApiMarket.repository;

import com.joni23s.finalWorkApiMarket.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long> {


}
