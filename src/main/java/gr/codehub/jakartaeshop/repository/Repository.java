/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codehub.jakartaeshop.repository;

 
import java.util.List;
import java.util.Optional;

/**
 *
 * @author iracl
 */
public interface Repository<T> {
    Optional<T> save(T t);
    Optional<T> findById(int id);
    List<T> findAll();
    Optional<T> update(int id, T t);
    boolean delete(int id);
}
