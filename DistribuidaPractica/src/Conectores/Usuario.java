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
public class Usuario {
    
    int idusuario;
    String nombre;
    
    public Usuario(){
        
    }

    public Usuario(int idusuario, String nombre) {
        this.idusuario = idusuario;
        this.nombre = nombre;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
