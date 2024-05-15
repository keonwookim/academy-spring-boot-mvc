package com.nhnacademy.springbootmvc.repository;

import com.nhnacademy.springbootmvc.domain.Student;

public interface StudentRepository {
    boolean exists(long id);

    Student register(String name, String email, int score, String comment);

    Student getStudent(long id);

}
