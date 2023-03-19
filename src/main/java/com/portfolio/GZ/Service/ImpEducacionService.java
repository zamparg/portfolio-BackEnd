package com.portfolio.GZ.Service;

import com.portfolio.GZ.entity.Educacion;
import com.portfolio.GZ.repository.IEducacionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpEducacionService {
    
    @Autowired 
    IEducacionRepository ieducacionRepository;
    
  
    public List<Educacion> list() {
        return ieducacionRepository.findAll();
    }
    public Optional<Educacion> getOne(Long id){
        return ieducacionRepository.findById(id);
    }
    public Optional<Educacion> getByTittle(String tittle){
        return ieducacionRepository.findByTittle(tittle);
    }

    public void save(Educacion educacion) {
        ieducacionRepository.save(educacion);
    }

    public void delete(Long id) {
        ieducacionRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return ieducacionRepository.existsById(id);
    }
    
    public boolean existsByTittle(String tittle){
        return ieducacionRepository.existsByTittle(tittle);
    }

    
}
