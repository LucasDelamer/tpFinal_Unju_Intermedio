/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Profesor;

/**
 *
 * @author lucas
 */
public interface ProfesorDao {
   public void insert(Profesor profesor);
    public void update(Profesor profesor);
    public void delete(Integer id_profesor);
    public List read();
    public Profesor readOne(Integer id_profesor);   
}
