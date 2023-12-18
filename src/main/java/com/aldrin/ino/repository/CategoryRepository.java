/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.repository;

import com.aldrin.ino.model.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ALDRIN B. C.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findAllById(Long id);

    public List<Category> findAllByCategoryContaining(String Lastname);

}
