/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import Conectores.Estado;

/**
 *
 * @author MoisesDario
 */
public class Ciudad {
    
    int idciudad;
    int idestado;
    String nombre;
    Estado estado;
    
    public Ciudad(){
        
    }

    public Ciudad(int idciudad, int idestado, String nombre) {
        this.idciudad = idciudad;
        this.idestado = idestado;
        this.nombre = nombre;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    public int getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(int idciudad) {
        this.idciudad = idciudad;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
}
