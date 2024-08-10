package com.itla.modelo;

public class Contacto {
        
        private Long idEmpleado = null;
        
        private String nombre;
        
        private String apellidos;
        
        private String empresa;
        
        private String telefono;
        
        private String correo;

    public Contacto(String nombre, String apellidos, String empresa, String telefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.empresa = empresa;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
        
        
}
