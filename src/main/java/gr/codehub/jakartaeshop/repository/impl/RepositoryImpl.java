/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository.impl;

import gr.codehub.jakartaeshop.repository.Repository;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

/**
 *
 * @author iracl
 */
public abstract class RepositoryImpl<T> implements Repository<T> {

    @PersistenceContext(unitName="Persistence")
    private EntityManager em;
    
    @Resource
    private UserTransaction userTransaction;
    
    @Override
    
    public Optional<T> save(T t) {
         try {
          userTransaction.begin();
            em.persist(t);
           userTransaction.commit();
            return Optional.of(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    /**
     *
     * @param id
     * @return
     */
    //@Transactional
    @Override
    public Optional<T> findById(int id) {
       T t = em.find( getClassType() , id);
   //   T t = (T)em.createQuery("select p from " + getClassName() +" p where id = "+id).getSingleResult();
    
     
        return t != null ? Optional.of(t) : Optional.empty();
    }

    
    public abstract Class<T> getClassType();
    public abstract String getClassName();
    
    @Override
    public List<T> findAll() {
        return em.createQuery("from " + getClassName()).getResultList();
    }
        
//??
    @Override
    public Optional<T> update(int id, T t) {
        Optional<T> tOpt= findById(id);
        if (tOpt.isEmpty()) return Optional.empty();
        T tObj= tOpt.get();
        copyValues(t, tObj)  ;
        return save(tObj);
    }

    
    public abstract void copyValues(T tSource, T tTarget);
    
   /**
     * Deleting a persistent instance
     *
     * @param id
     * @return success
     */
    @Override
    public boolean delete(int id) {
        T persistentInstance = em.find(getClassType(), id);
        if (persistentInstance != null) {

            try {
                userTransaction.begin();
            em.remove(persistentInstance);
            userTransaction.commit();
            } catch (Exception e) {
                //e.printStackTrace();
                return false;
            }
            return true;
        }
        return false;
    }
}
