package com.java.student.dao;

import com.java.student.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> showStudentDao();
    String addStudentDao(Student student);
    Student searchStudentDao(int roll);
    String deleteStudentDao(int roll);
    String updateStudentDao(Student studentUpdate);
}
