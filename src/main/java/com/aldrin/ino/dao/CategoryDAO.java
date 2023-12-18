/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.dao;


import com.aldrin.ino.config.AppConfig;
import com.aldrin.ino.model.Category;
import com.aldrin.ino.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ALDRIN B. C.
 */
public class CategoryDAO {

    private AnnotationConfigApplicationContext context;

    private CategoryRepository categoryRepository;

    public CategoryDAO() {

        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.categoryRepository = context.getBean(CategoryRepository.class);
    }
    


    public List<Category> listOfUser() {

        List<Category> category = new ArrayList<>();
        try {
            category = this.categoryRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return category;
    }

    public Category saveUser(Category user) {
        Category userList = null;
        try {
            userList = this.categoryRepository.saveAndFlush(user);

        } catch (Exception e) {

            System.out.println("eRROR: " + e.getMessage());
        }
        return userList;
    }

    public boolean delete(Long id) {
        try {
            this.categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public List<Category> findById(Long id) {
        List<Category> lista = categoryRepository.findAllById(id);
        return lista;
    }

    public List<Category> findByLastnameContaining(String lastname) {
        List<Category> lista = categoryRepository.findAllByCategoryContaining(lastname);
        return lista;
    }
    

    
}
