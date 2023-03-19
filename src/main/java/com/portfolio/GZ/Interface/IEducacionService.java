
package com.portfolio.GZ.Interface;

import com.portfolio.GZ.entity.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> list();
    public void save(Educacion educacion);
    public void delete(Long id);

    public Educacion findEducacion(Long id);
   
}
