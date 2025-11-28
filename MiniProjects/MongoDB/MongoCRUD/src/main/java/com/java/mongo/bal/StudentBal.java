package com.java.mongo.bal;

import com.java.mongo.dao.StudentDao;
import com.java.mongo.dao.StudentsDaoImpl;
import com.java.mongo.model.Course;
import com.java.mongo.model.Student;

import java.util.List;

public class StudentBal {
  StudentDao studentDao = new StudentsDaoImpl();

  public String addStudentBal(Student s) {
    String result = validateStudent(s);

    if (!result.equals("OK")) {
      return result;
    }

    Student existing = studentDao.searchStudent(s.getRoll());

    if (existing != null) {
      return "Student Already Exists.";
    }

    return studentDao.addStudent(s);
  }

  public Student searchStudentBal(int roll) {
    return studentDao.searchStudent(roll);
  }

  public String updateStudentBal(Student s) {

    String result = validateStudent(s);

    if (!result.equals("OK")) {
      return result;
    }

    Student existing = studentDao.searchStudent(s.getRoll());
    if (existing == null) {
      return "Student Not Found.";
    }

    return studentDao.updateStudent(s);
  }

  public String deleteStudentBal(int roll) {
    Student s = studentDao.searchStudent(roll);
    if (s == null) {
      return "Student Not Found.";
    }
    return studentDao.deleteStudent(roll);
  }

  public List<Student> listAllStudentsBal() {
    return studentDao.listAllStudents();
  }

  public List<Student> listStudentsByCourseBal(String courseName) {
    Course course;

    try {
      course = Course.valueOf(courseName.toUpperCase());
    } catch (IllegalArgumentException e) {
      return null;
    }
    return studentDao.listStudentsByCourse(course.name());
  }

  public List<Student> listTopStudentsBal(int limit) {
    return studentDao.listTopStudents(limit);
  }

  private String validateStudent(Student s) {

    StringBuilder sb = new StringBuilder();
    if (s.getRoll() <= 0) {
      sb.append("Roll number must be positive.");
    }

    if (s.getName() == null || s.getName().trim().length() == 0) {
      sb.append("Name cannot be empty.");
    }

    if (s.getMarks() < 0 || s.getMarks() > 100) {
      sb.append("Marks must be between 0 and 100.");
    }

    if (s.getCity() == null || s.getCity().trim().length() == 0) {
      sb.append("City cannot be empty.");
    }

    if (s.getCourse() == null) {
      sb.append("Course is required.");
    }

    if (sb.length() == 0) {
      return "OK";
    }

    return sb.toString();
  }
}
