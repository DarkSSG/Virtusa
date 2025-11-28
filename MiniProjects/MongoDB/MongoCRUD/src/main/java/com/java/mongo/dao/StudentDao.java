package com.java.mongo.dao;

import com.java.mongo.model.Student;
import java.util.List;

public interface StudentDao {

  String addStudent(Student s);
  Student searchStudent(int roll);
  String updateStudent(Student s);
  String deleteStudent(int roll);
  List<Student> listAllStudents();
  List<Student> listStudentsByCourse(String course);
  List<Student> listTopStudents(int limit);

}
