/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Profesor;

/**
 *
 * @author lucas
 */
public class ProfesorDao_Impl implements ProfesorDao {
     static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bdfinal";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    
    
    private void registerDriver() {
        
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println("ERROR: fallo la conexion JDBC DRIVER");
            e.printStackTrace();
        }
    }
    
     @Override
    public void insert (Profesor profesor) {
        Connection conn = null;
        try {
            registerDriver();
            // Abrir conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            try (Statement stmt = conn.createStatement()) {
                //enviar comando insert
               stmt.executeUpdate("INSERT INTO `profesores`(`id_profesor`, `legajo`, `nombre`, `apellido`, `telefono`) \n" +
           " VALUES ("+profesor.getId_profesor()+",'"+profesor.getLegajo()+"','"+profesor.getNombre()+"','"+profesor.getApellido()+"','"+profesor.getTelefono()+"')");   
        
//             ("+"''"+profesor.getLegajo()+",'"+profesor.getNombre()+"','"+profesor.getApellido()+"','"+profesor.getTelefono()+"');");                                
                        }                
            } catch (SQLException e) {
            
                throw new RuntimeException(e);
              }  finally {
                      if (conn != null ) {
                      try { 
                           conn.close();                      
                      } catch (SQLException e){
                            e.printStackTrace();
                      }
                      }
                      }
        }
        
    @Override
    public void update(Profesor profesor){
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            String sqla = "UPDATE `profesores` SET `legajo` = '"+profesor.getLegajo()+"', `nombre` = '"+profesor.getNombre()+"' , `apellido` = '"+profesor.getApellido()+"' , `telefono` = '"+profesor.getTelefono()+"' WHERE `profesores`.`id_profesor` ="+profesor.getId_profesor()+"";
     //"UPDATE `profesores` SET `legajo`='"+profesor.getLegajo()+"', `nombre` = '"+profesor.getNombre()+"',`apellido`='"+profesor.getApellido()+"',  WHERE `profesores`.`id_profesor` ="+profesor.getId_profesor()+"" ;               
            try (PreparedStatement pstmt = conn.prepareStatement(
                    sqla)){
                pstmt.executeUpdate();
                
                
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public void delete (Integer id_profesor) {
        Connection conn = null;
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE FROM `profesores` WHERE id_profesor = ?")){
                pstmt.setInt(1, id_profesor);                
                pstmt.executeUpdate();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @Override
    public List read () {
       Connection conn = null;
       
       ArrayList<Profesor>listaProfesor= new ArrayList<>();
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM `profesores` WHERE 1")){
               
                
                try (ResultSet rs = ps.executeQuery()) {
                    
                 while(rs.next()) {
                     Profesor prof=new Profesor();
                     prof.setId_profesor(rs.getInt("id_profesor"));
                     prof.setLegajo(rs.getInt("legajo"));
                     prof.setNombre(rs.getString("nombre"));
                     prof.setApellido(rs.getString("apellido"));
                     prof.setTelefono(rs.getString("telefono"));
                     listaProfesor.add(prof);
                 }   
//                    if (rs.next()) {
//                        //obtener las columnas
//                        profesor = new Profesor(
//                        rs.getInt("id_profesor"), 
//                        rs.getString("nombre"));
//                                        
//                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaProfesor;
    }
    
    @Override
    public Profesor readOne (Integer id_profesor) {
       Connection conn = null;
       Profesor profesor = null;
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM `profesores` WHERE id_profesor = ?")){
                ps.setInt(1, id_profesor);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        //obtener las columnas
                        profesor = new Profesor(
                        rs.getInt("id_profesor"),
                        rs.getInt("legajo"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"));
                                        
                    }
                }
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return profesor;
    }
    

    
   
                }
