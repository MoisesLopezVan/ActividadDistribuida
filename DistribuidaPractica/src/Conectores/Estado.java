/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

/**
 *
 * @author MoisesDario
 */
public class Estado {
    int idestado;
    String nombre;
    
    public Estado(){
        
    }

    public Estado(int idestado, String nombre) {
        this.idestado = idestado;
        this.nombre = nombre;
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
