/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.repository;

import com.aldrin.ino.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ALDRIN B. C.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findAllById(Long id);

    public List<User> findAllByLastnameContaining(String Lastname);

    public User findByUsernameAndPassword(String username, String password);
}
