/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conectores;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author MoisesDario
 */
public class ConexionRemota {
    
    public static Connection conexionSQL(){
        Connection Server = null;
        try{
            String urlSql="jdbc:sqlserver://localhost:1433;databaseName=bdesc";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();       
            Server=(Connection) DriverManager.getConnection(urlSql,"Rock444","1234");
            if(Server != null){
                System.out.print("Conectado a SQL");
                return Server;
            } else {
            }
        }catch(Exception e){
            System.out.print(e);
            System.out.print("No esta conectado");
            return Server;
        }
        return Server;
    }
    
    public static Connection conexionMySql(){
        Connection MariaDB = null;
        try{
            String urlMysql="jdbc:mysql://localhost:3308/bdadm";
            Class.forName("com.mysql.jdbc.Driver").newInstance();       
            MariaDB=(Connection) DriverManager.getConnection(urlMysql,"test","123456");
            if(MariaDB != null){
                System.out.print("Conectado a MySQL");
                return MariaDB;
            } else {
            }
        }catch(Exception e){
            System.out.print(e);
            System.out.print("No esta conectado");
            return MariaDB;
        }
        return MariaDB;
    }
    
    public static Connection conexionDB2(){
       Connection DB2 = null;
        try{
            String urldb2="jdbc:db2://192.168.43.235:50000/bdadm";
            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();       
            DB2=(Connection) DriverManager.getConnection(urldb2,"Rock444","1234");
            if(DB2 != null){
                System.out.print("Conectado a DB2");
                return DB2;
            } else {
            }
        }catch(Exception e){
            System.out.print(e);
            System.out.print("No esta conectado");
            return DB2;
        }
        return DB2;
    }
    
    public static Connection conexionPOST(){
        Connection Postgresql = null;
           try{
               String urlpostgres="jdbc:postgresql://192.168.1.74:5432/bdsec";
               Class.forName("org.postgresql.Driver").newInstance();       
               Postgresql=(Connection) DriverManager.getConnection(urlpostgres,"SAINZ","12345");
               if(Postgresql != null){
                   System.out.print("Conectado a Postgres");
                   return Postgresql;
               } else {
               }
           }catch(Exception e){
               System.out.print(e);
               System.out.print("No esta conectado");
               return Postgresql;
           }
           return Postgresql;
       }

    }
