/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.dao;

import com.aldrin.ino.config.AppConfig;
import com.aldrin.ino.model.User;
import com.aldrin.ino.repository.CategoryRepository;
import com.aldrin.ino.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ALDRIN B. C.
 */
public class UserDAO {

    private AnnotationConfigApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    public UserDAO() {

        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.userRepository = context.getBean(UserRepository.class);
    }

    public List<User> listOfUser() {

        List<User> user = new ArrayList<>();
        try {
            user = this.userRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public User saveUser(User user) {
        User userList = null;
        try {
            userList = this.userRepository.saveAndFlush(user);

        } catch (Exception e) {

            System.out.println("eRROR: " + e.getMessage());
        }
        return userList;
    }

    public boolean delete(Long id) {
        try {
            this.userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public List<User> findById(Long id) {
        List<User> lista = userRepository.findAllById(id);
        return lista;
    }

    public List<User> findByLastnameContaining(String lastname) {
        List<User> lista = userRepository.findAllByLastnameContaining(lastname);
        return lista;
    }

    public User loginUser(String username, String password) {
        User user = null;
        try {
            user = this.userRepository.findByUsernameAndPassword(username, password);
        } catch (Exception e) {
        }
        return user;
    }

}
