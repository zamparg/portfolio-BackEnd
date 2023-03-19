package com.portfolio.GZ.Interface;

import com.portfolio.GZ.entity.Experiencia;
import java.util.List;
import java.util.Optional;
 
public interface IExperienciaService {
    public List<Experiencia> list();
    public Optional<Experiencia> getExperiencia(Long id);
    public Optional<Experiencia> getByNombreE(String id);
    public void saveExperiencia(Experiencia experiencia);
    public void deleteExperiencia(Long id);
    public boolean existsById(Long id);
    public boolean existsByNombreE(String nombreE);
}
