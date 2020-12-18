/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Departement;
import javax.ejb.Stateless;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dell
 */
@Stateless
public class DepartementFacade extends AbstractFacade<Departement> implements DepartementFacadeLocal {

    @PersistenceContext(unitName = "EmpDeptPU")
    private EntityManager em;
    private EntityTransaction tx;
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartementFacade() {
        super(Departement.class);
        this.emf = Persistence.createEntityManagerFactory("EmpDeptPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }
    


    @Override
     public List<Departement> Tous() {
        return em.createNamedQuery("Departement.findAll").getResultList();
        
    }
    @Override
    public List<Departement> findAll() {
        Query req = em.createQuery(" select d from Departement d");
               
        return req.getResultList();
        
    }
    @Override
     public void add(Departement E) {
        try {
            em.persist(E);
            tx.commit();
        } 
        catch (Exception ex) {
            System.out.println("Error : " + ex.getMessage());
         
        }
    }
    
    @Override
    public void update(Departement E) 
    {
            em.merge(E);
            tx.commit();
    }

    /**
     *
     * @param Code
     * @return
     */
    @Override
    public Departement FindByCode(String Code)
    {
        Departement d = em.find(Departement.class, Code);
        
        return d ;
    }
    @Override
    public void DeleteByCode(String Code)
    {
        Departement d = em.find(Departement.class, Code);
        if(d!=null)
        {   
            em.remove(d);
            tx.commit();
            
        }
        else
             System.out.println("Error !");
            
    }
}
