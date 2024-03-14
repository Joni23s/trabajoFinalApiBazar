package com.joni23s.finalWorkApiMarket.repository;

import com.joni23s.finalWorkApiMarket.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <ClientEntity, Long> {
}
