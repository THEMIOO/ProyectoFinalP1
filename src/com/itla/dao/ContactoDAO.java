package com.itla.dao;

import com.itla.modelo.Contacto;
import java.util.List;

public interface ContactoDAO {
    
    void Insertar(Contacto con);
    
    void Modificar(Contacto con);
    
    void Eliminar(Contacto con);
    
    List<Contacto> ObtenerTodosContactos();
    
    Contacto Obtener(Long id);
}
