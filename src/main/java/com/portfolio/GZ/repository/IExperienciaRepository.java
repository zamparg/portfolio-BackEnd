package com.portfolio.GZ.repository;

import com.portfolio.GZ.entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long>{
   public Optional<Experiencia> findByRole(String role);
   public boolean existsByRole(String role);
    
}
