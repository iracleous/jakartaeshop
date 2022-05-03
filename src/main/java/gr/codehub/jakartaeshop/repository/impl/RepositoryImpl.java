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

    @PersistenceContext(unitName = "Persistence")
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
        T t = em.find(getClassType(), id);
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

        try {
            userTransaction.begin();
            T t0 = em.find(getClassType(), id);
            if (t0 == null) {
                userTransaction.commit();
                return Optional.empty();
            }
            copyValues(t0, t);
            em.persist(t0);
            userTransaction.commit();
            return Optional.of(t0);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public abstract void copyValues(T tTarget, T tSource);

    /**
     * Deleting a persistent instance
     *
     * @param id
     * @return success
     */
    @Override
    public boolean delete(int id) {
        try {
            userTransaction.begin();
            T persistentInstance = em.find(getClassType(), id);
            if (persistentInstance != null) {
                em.remove(persistentInstance);
                userTransaction.commit();
                return true;
            } else {
                userTransaction.commit();
                return false;

            }
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }

    }
}
