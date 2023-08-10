package com.example.apifinancespring.repositories;

import com.example.apifinancespring.models.DespesasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesasRepository extends JpaRepository<DespesasModel, Long>{
}
