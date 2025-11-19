package com.java.student.dao;

import com.java.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImplementation implements StudentDao {

    static List<Student> studentList;

    static {
        studentList = new ArrayList<>();
    }

    @Override
    public List<Student> showStudentDao() {
        return studentList;
    }

    @Override
    public String addStudentDao(Student student) {
        studentList.add(student);
        return "Student Record Added...";
    }

    @Override
    public Student searchStudentDao(int roll) {
        //loop method
        /*
        for (Student s : student) {
            if (s.getRoll() == roll) {
                return s
            }
            return null
        }
        */
        return studentList.stream().filter(s -> s.getRoll() == roll).findFirst().orElse(null);
    }

    @Override
    public String deleteStudentDao(int roll) {
        Student studentFound = searchStudentDao(roll);
        if (studentFound != null) {
            studentList.remove(studentFound);
            return "Student Record Deleted...";
        }
        return "Student Record not Found...";
    }

    @Override
    public String updateStudentDao(Student studentUpdate) {
        Student studentFound = searchStudentDao(studentUpdate.getRoll());
        if (studentFound != null) {
            studentFound.setName(studentUpdate.getName());
            studentFound.setCourse(studentUpdate.getCourse());
            studentFound.setGender(studentUpdate.getGender());
            studentFound.setMarks(studentUpdate.getMarks());
            studentFound.setGrade(studentUpdate.getGrade());

            return "Student Records for roll no. " + studentUpdate.getRoll() +" updated.";
        }
        return "Student Records for roll no. " + studentUpdate.getRoll() +" not found.";
    }
}
