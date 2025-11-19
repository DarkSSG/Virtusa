package com.java.student.bal;

import com.java.student.dao.StudentDao;
import com.java.student.dao.StudentDaoImplementation;
import com.java.student.exception.StudentException;
import com.java.student.model.Grade;
import com.java.student.model.Student;

import java.util.List;

public class StudentBal {

    static StringBuilder sb;
    static StudentDao studentDao;

    static {
        sb = new StringBuilder();
        studentDao = new StudentDaoImplementation();
    }

    public List<Student> showStudentBal() {
        return studentDao.showStudentDao();
    }

    public String addStudentBal(Student student) throws StudentException {
        if (validateStudent(student)) {
            Grade grade = gradeCalculate(student.getMarks());
            student.setGrade(grade);
            return studentDao.addStudentDao(student);
        }
        throw new StudentException(sb.toString());
    }

    public Student searchStudentBal(int roll) {
        return studentDao.searchStudentDao(roll);
    }

    public String updateStudentBal(Student student) throws StudentException {
        if (validateStudent(student)) {
            Grade grade = gradeCalculate(student.getMarks());
            student.setGrade(grade);
            return studentDao.updateStudentDao(student);
        }
        throw new StudentException(sb.toString());
    }

    public String deleteStudentBal(int roll) {
        return studentDao.deleteStudentDao(roll);
    }

    private Grade gradeCalculate(int marks) {
        if (marks >= 90) {
            return Grade.A_PLUS;
        }
        else if (marks >= 80) {
            return Grade.A;
        }
        else if (marks >= 70) {
            return Grade.B;
        }
        else if (marks >= 60) {
            return Grade.C;
        }
        else if (marks >= 50) {
            return Grade.D;
        }
        else if (marks >= 40) {
            return Grade.E;
        }
        else {
            return Grade.F;
        }
    }

    private boolean validateStudent(Student student) {
        sb.setLength(0);
        boolean isValid = true;

        if (student.getRoll() <= 0) {
            sb.append("Student Roll should be > 0...\n");
            isValid = false;
        }

        if (student.getName() == null || student.getName().trim().length() < 3) {
            sb.append("Name should be min 3 Characters...\n");
            isValid = false;
        }

        if (student.getGender() == null) {
            sb.append("Gender must be MALE or FEMALE...\n");
            isValid = false;
        }

        if (student.getCourse().length() < 4) {
            sb.append("Course should be min 4 Characters...\n");
            isValid = false;
        }

        if (student.getMarks() < 0 || student.getMarks() > 100) {
            sb.append("Marks must be between 0 and 100...\n");
            isValid = false;
        }

        return isValid;
    }
}


