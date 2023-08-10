package com.example.apifinancespring.repositories;

import com.example.apifinancespring.models.EmpenhoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmpenhoRepository  extends JpaRepository<EmpenhoModel, UUID>{
}
