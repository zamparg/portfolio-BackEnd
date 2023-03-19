package com.portfolio.GZ.Interface;

import com.portfolio.GZ.entity.Proyectos;
import java.util.List;


public interface IProyectosService {
    public List<Proyectos> getProyectos();
    
    public void saveProyectos(Proyectos proyectos);
    
    public void deleteProyectos(Long id);
    
    public Proyectos findProyectos(Long id);
}
