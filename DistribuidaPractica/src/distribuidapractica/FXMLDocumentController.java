/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distribuidapractica;

import Conectores.Alumno;
import Conectores.Ciudad;
import Conectores.ConexionRemota;
import Conectores.Estado;
import Conectores.Usuario;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author MoisesDario
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private Button conexion;
    
    //Tabla
    @FXML
    private TableView tablaAlumno ;
    @FXML
    private TableColumn idalumno;
    @FXML
    private TableColumn nombre;
    @FXML
    private TableColumn idciudad;
    @FXML
    private TableColumn idestado;
    @FXML
    private TableColumn idusuario;
   
    
    //Listas Observables
    ObservableList<Alumno> dataAlumno = FXCollections.observableArrayList();
    
    //ArrayList   
    ArrayList<Alumno> listaAlumnos = new ArrayList();
    ArrayList<Usuario> listaUsuarios = new ArrayList();
    ArrayList<Ciudad> listaCiudades = new ArrayList();
    ArrayList<Estado> listaEstados = new ArrayList();

    //Variable
    Connection conexionDB2 = null;
    Connection conexionPostgres = null;
    Connection conexionSQL=null;
    Connection conexionMYSQL=null;
    
        
    @FXML
    private void conexiongeneral(ActionEvent event){  
          
        conexionSQL = ConexionRemota.conexionSQL();
        conexionMYSQL = ConexionRemota.conexionMySql();
        conexionDB2 = ConexionRemota.conexionDB2();
        conexionPostgres = ConexionRemota.conexionPOST();
        obtenerSQL();
        obtenerMyDB(); 
        obtenerDB2();
        obtenerPOST();
        relacionBusqueda();
    }
    
    //Obtener la tabla Alumno
    private void obtenerSQL(){
        try{
            String sql1="select * from alumno" ;
            Statement st= conexionSQL.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            while(rs.next()){
                System.out.println(rs.getInt(1)  + rs.getInt(2) + rs.getString(3) + rs.getInt(4));
                Alumno alumno = new Alumno(rs.getInt("idalumno"),rs.getInt("idusuario"),rs.getString("nombre"),rs.getInt("idciudad"));
                listaAlumnos.add(alumno);
            }
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);              
        }  
    }  
    
    //Obtener la tabla Ciudad
    private void obtenerMyDB(){
  
        try{
            String sql2="select * from ciudad" ;
            Statement st= conexionMYSQL.createStatement();
            ResultSet rs = st.executeQuery(sql2);
            while(rs.next()){
                System.out.println((rs.getInt(1)  + rs.getInt(2) + rs.getString(3)));
                Ciudad ciudad = new Ciudad(rs.getInt("idciudad"),rs.getInt("idestado"),rs.getString("nombre"));
                listaCiudades.add(ciudad);
            }
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);              
        }    
    }
   
    //Obtener la tabla Estado
    private void obtenerDB2(){
        try{
            String sql3="select * from estado" ;
            Statement st= conexionDB2.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while(rs.next()){
                System.out.println(rs.getInt(1)  + rs.getString(2));
                Estado estado = new Estado(rs.getInt("idestado"),rs.getString("nombre"));
                listaEstados.add(estado);
            }
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);              
        }    
    }  
    
    //Obtener la tabla Usuario
    private void obtenerPOST(){
        try{
            String sql4="select * from usuario" ;
            Statement st= conexionPostgres.createStatement();
            ResultSet rs = st.executeQuery(sql4);
            while(rs.next()){
                System.out.println(rs.getInt(1) + rs.getString(2));
                Usuario usuario = new Usuario(rs.getInt("idusuario"),rs.getString("nombre"));
                listaUsuarios.add(usuario);
            }
        }catch(SQLException e){
            System.out.println("Conexion fallida");
            System.out.println("Error" + e);              
        }    
    }  
    
    public void relacionBusqueda(){
        
        int contador;
        boolean asignado;
        for(int i = 0; i<listaCiudades.size();i++){
            contador=0;
            asignado=false;
            while(!asignado && contador<listaEstados.size()){
                if(listaCiudades.get(i).getIdestado()==listaEstados.get(contador).getIdestado()){
                    asignado=true;
                    listaCiudades.get(i).setEstado(listaEstados.get(contador));
                }else{
                    contador++;
                }
            }
        }
        
        for(int i = 0; i<listaAlumnos.size();i++){
            contador=0;
            asignado=false;
            while(!asignado && contador<listaCiudades.size()){
                if(listaCiudades.get(contador).getIdciudad()==listaAlumnos.get(i).getIdciudad()){
                    asignado=true;
                    listaAlumnos.get(i).setNombreCiudad(listaCiudades.get(contador).getNombre());
                    listaAlumnos.get(i).setNombreEstado(listaCiudades.get(contador).getEstado().getNombre());
                }else{contador++;}
            }
        }
        
        for(int i = 0; i<listaAlumnos.size();i++){
            contador=0;
            asignado=false;
            while(!asignado && contador<listaUsuarios.size()){
                if(listaUsuarios.get(contador).getIdusuario()==listaAlumnos.get(i).getIdusuario()){
                    asignado=true;
                    listaAlumnos.get(i).setNombreUsuario(listaUsuarios.get(contador).getNombre());
                }else{contador++;}
            }
        }
     
        for(int i = 0; i<listaAlumnos.size();i++){
            dataAlumno.add(listaAlumnos.get(i));
        }
        tablaAlumno.getItems().clear();
        tablaAlumno.getItems().addAll(dataAlumno);
       
        
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }    
 
}
