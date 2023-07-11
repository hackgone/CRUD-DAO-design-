package com.piyush.cruddemo.dao;

import com.piyush.cruddemo.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{
    //entity manager
    private EntityManager entityManager;
    //inject entity manager

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }
}
