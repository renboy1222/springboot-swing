/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.ino.dao;

import com.aldrin.ino.config.AppConfig;
import com.aldrin.ino.model.Category;
import com.aldrin.ino.model.Unit;
import com.aldrin.ino.repository.UnitRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ALDRIN B. C.
 */
public class UnitDAO {

    private AnnotationConfigApplicationContext context;

    private UnitRepository unitRepository;

    public UnitDAO() {

        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.unitRepository = context.getBean(UnitRepository.class);
    }

    public List<Unit> listOfUnits() {

        List<Unit> unit = new ArrayList<>();
        try {
            unit = this.unitRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return unit;
    }

    public Unit saveUnit(Unit unit) {
        Unit unitList = null;
        try {
            unitList = this.unitRepository.saveAndFlush(unit);
        } catch (Exception e) {
            System.out.println("eRROR: " + e.getMessage());
        }
        return unitList;
    }

    public boolean delete(Long id) {
        try {
            this.unitRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public List<Unit> findById(Long id) {
        List<Unit> lista = unitRepository.findAllById(id);
        return lista;
    }

    public List<Unit> findByUnitContaining(String unit) {
        List<Unit> lista = unitRepository.findAllByUnitContaining(unit);
        return lista;
    }

}
