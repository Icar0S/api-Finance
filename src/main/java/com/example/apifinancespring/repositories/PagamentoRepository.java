package com.example.apifinancespring.repositories;

import com.example.apifinancespring.models.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<PagamentoModel, UUID>{
}
