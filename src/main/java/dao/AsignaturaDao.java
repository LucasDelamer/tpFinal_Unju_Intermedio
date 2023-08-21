/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Asignatura;

/**
 *
 * @author lucas
 */
public interface AsignaturaDao {
   public void insert(Asignatura asignatura);
    public void update (Asignatura asignatura);
    public void delete(Integer id_asignatura);
    public List read(); 
    public Asignatura readOne(Integer id_asignatura);
}
