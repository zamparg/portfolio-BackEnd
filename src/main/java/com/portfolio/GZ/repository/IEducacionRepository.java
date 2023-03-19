
package com.portfolio.GZ.repository;

import com.portfolio.GZ.entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{
    public Optional<Educacion> findByTittle(String tittle);
    public boolean existsByTittle(String tittle);
}
