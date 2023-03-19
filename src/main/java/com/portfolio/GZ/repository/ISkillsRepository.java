
package com.portfolio.GZ.repository;

import com.portfolio.GZ.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepository extends JpaRepository<Skills, Long>{
    
}
