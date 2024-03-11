package com.joni23s.trabajoFinalApiBazar.repository;

import com.joni23s.trabajoFinalApiBazar.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <ClientEntity, Long> {
}
