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
import model.Asignatura;

/**
 *
 * @author lucas
 */
public class AsignaturaDao_Impl implements AsignaturaDao {
    
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
    public void insert (Asignatura asignatura) {
        Connection conn = null;
        try {
            registerDriver();
            // Abrir conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            try (Statement stmt = conn.createStatement()) {
                //enviar comando insert
               stmt.executeUpdate("INSERT INTO `asignaturas`(`id_asignatura`, `nombre`)\n" +
"                       VALUES ("
                        + asignatura.getId_asignatura() + ",'"
                        + asignatura.getNombre() + "');" );
                                               
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
    public void update(Asignatura asignatura){
        Connection conn = null;
        try {
            registerDriver();
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            String sqla = "UPDATE `asignaturas` SET `nombre` = '"+asignatura.getNombre()+"' WHERE `asignaturas`.`id_asignatura` ="+asignatura.getId_asignatura()+"";
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
    public void delete (Integer id_asignatura) {
        Connection conn = null;
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement pstmt = conn.prepareStatement(
                    "DELETE FROM `asignaturas` WHERE id_asignatura = ?")){
                pstmt.setInt(1, id_asignatura);                
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
       
       ArrayList<Asignatura>listaAsignatura= new ArrayList<>();
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM `asignaturas` WHERE 1")){
               
                
                try (ResultSet rs = ps.executeQuery()) {
                    
                 while(rs.next()) {
                     Asignatura asign=new Asignatura();
                     asign.setId_asignatura(rs.getInt("id_asignatura"));
                     asign.setNombre(rs.getString("nombre"));
                     listaAsignatura.add(asign);
                 }   
//                    if (rs.next()) {
//                        //obtener las columnas
//                        asignatura = new Asignatura(
//                        rs.getInt("id_asignatura"), 
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
        return listaAsignatura;
    }
    
    @Override
    public Asignatura readOne (Integer id_asignatura) {
       Connection conn = null;
       Asignatura asignatura = null;
        try {
            registerDriver();
            //abre conexion
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            //consulta select  con id indicado
            try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM `asignaturas` WHERE id_asignatura = ?")){
                ps.setInt(1, id_asignatura);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        //obtener las columnas
                        asignatura = new Asignatura(
                        rs.getInt("id_asignatura"), 
                        rs.getString("nombre"));
                                        
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
        return asignatura;
    }
    
    
}
