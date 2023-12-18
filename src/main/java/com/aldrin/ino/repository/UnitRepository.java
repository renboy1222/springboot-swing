/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.repository;

import com.aldrin.ino.model.Category;
import com.aldrin.ino.model.Unit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ALDRIN B. C.
 */
public interface UnitRepository extends JpaRepository<Unit, Long> {

    public List<Unit> findAllById(Long id);

    public List<Unit> findAllByUnitContaining(String unit);
    
    

}
