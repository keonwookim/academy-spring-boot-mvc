package com.nhnacademy.springbootmvc.repository;

import com.nhnacademy.springbootmvc.domain.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public boolean exists(long id) {
        return false;
    }

    @Override
    public Student register(String name, String email, int score, String comment) {
        return null;
    }

    @Override
    public Student getStudent(long id) {
        return null;
    }
}
