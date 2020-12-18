/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Departement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dell
 */
@Local
public interface DepartementFacadeLocal {

//    void create(Departement departement);
//
//    void edit(Departement departement);
//
//    void remove(Departement departement);
//
//    Departement find(Object id);
//
//    List<Departement> findRange(int[] range);
//
//    int count();
//    
    public List<Departement> Tous();
    public List<Departement> findAll();
    public void add(Departement E) ;
    public void update(Departement E) ;
    public Departement FindByCode(String Code);
    public void DeleteByCode(String Code);
    
}
