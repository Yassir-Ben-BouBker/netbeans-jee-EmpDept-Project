/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Employe;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface EmployeFacadeLocal {
//
//    void create(Employe employe);
//
//    void edit(Employe employe);
//
//    void remove(Employe employe);
//
//    Employe find(Object id);
//
//    List<Employe> findAll();
//
//    List<Employe> findRange(int[] range);
//
//    int count();
    
    public boolean addEmploye(Employe e);
    public boolean updateEmploye(Employe e);
    public boolean deleteEmploye(Employe e);
    public Employe findByCode(String code);
    public List<Employe> findAll();
    public List<Employe> EmpByDept(String code);
    
}
