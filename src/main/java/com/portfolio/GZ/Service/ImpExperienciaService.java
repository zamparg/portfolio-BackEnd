package com.portfolio.GZ.Service;

import com.portfolio.GZ.entity.Experiencia;
import com.portfolio.GZ.repository.IExperienciaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService{
    @Autowired IExperienciaRepository iexperienciaRepository;
    
    public List<Experiencia> list() {
        return iexperienciaRepository.findAll();
    }
    

    public Optional<Experiencia> getExperiencia(Long id) {
        return iexperienciaRepository.findById(id);
    }
  
    public Optional<Experiencia> getByRole(String role) {
        return iexperienciaRepository.findByRole(role);
    }

    
    public boolean existsById(Long id){
        return iexperienciaRepository.existsById(id);
    }

    public boolean existsByRole(String role){
        return iexperienciaRepository.existsByRole(role);
    }



    public void saveExperiencia(Experiencia experiencia) {
        iexperienciaRepository.save(experiencia);
    }


    public void deleteExperiencia(Long id) {
        iexperienciaRepository.deleteById(id);
    }

    
}
