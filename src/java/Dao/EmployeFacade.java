/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Departement;
import Entity.Employe;
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
public class EmployeFacade extends AbstractFacade<Employe> implements EmployeFacadeLocal {

    @PersistenceContext(unitName = "EmpDeptPU")
    private EntityManager em;
    private EntityTransaction tx;
    private EntityManagerFactory emf;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeFacade() {
        super(Employe.class);
        this.emf = Persistence.createEntityManagerFactory("EmpDeptPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    public boolean addEmploye(Employe e)
    {
        if(findByCode(e.getIdEmp()) != null)
            return false;
        tx.begin();
        em.persist(e);
        tx.commit();
        return true;
    }
    
    public boolean updateEmploye(Employe e) {
        if(findByCode(e.getIdEmp()) == null)
            return false;
        tx.begin();
        em.merge(e);
        tx.commit();
        return true;
    }

    public boolean deleteEmploye(Employe e) {
        if(findByCode(e.getIdEmp()) == null)
            return false;
        tx.begin();
        em.remove(e);
        tx.commit();
        return true;
    }
    
    public Employe findByCode(String code)
    {
        Employe e;
        e = null;
        tx.begin();
        e = em.find(Employe.class, code);
        tx.commit();
        return e;
    }
    
    public List<Employe> findAll() {
        Query req = em.createQuery(" select d from Departement d");
               
        return req.getResultList();
        
    }

    public List<Employe> EmpByDept(String code) {
        Departement dept = em.find(Departement.class, code);
        Query req ;
        req = null;
        if(dept!=null) 
        {
           req = em.createQuery(" select d from Employe d where d.refDept=:dept");
            req.setParameter("dept", dept);
           return req.getResultList();
        }
        return null;
       }
    
}
