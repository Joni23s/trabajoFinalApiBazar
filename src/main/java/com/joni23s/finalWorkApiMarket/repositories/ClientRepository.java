package com.joni23s.finalWorkApiMarket.repositories;

import com.joni23s.finalWorkApiMarket.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <ClientEntity, Long> {
}
