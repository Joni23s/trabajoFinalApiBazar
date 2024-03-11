package com.joni23s.trabajoFinalApiBazar.repository;

import com.joni23s.trabajoFinalApiBazar.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository <SaleEntity, Long> {


}
