package com.java.mongo.dao;

import com.java.mongo.model.Course;
import com.java.mongo.model.Student;
import com.java.mongo.util.ConnectionHelper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class StudentsDaoImpl implements StudentDao{

  MongoCollection<Document> col;

  public StudentsDaoImpl() {
    col = ConnectionHelper.getConnection().getCollection("students");
  }

  @Override
  public String addStudent(Student s) {
    Document document = new Document()
      .append("roll", s.getRoll())
      .append("name", s.getName())
      .append("course", s.getCourse().name())
      .append("marks", s.getMarks())
      .append("city", s.getCity());
    col.insertOne(document);

    return "Student added Successfully";
  }

  @Override
  public Student searchStudent(int roll) {
    Document doc = col.find(Filters.eq("roll", roll)).first();

    if (doc == null) {
      return null;
    }
    Student s = new Student();
    s.setRoll(doc.getInteger("roll"));
    s.setName(doc.getString("name"));
    s.setMarks(doc.getInteger("marks"));
    s.setCity(doc.getString("city"));

    Course c = Course.valueOf(doc.getString("course"));
    s.setCourse(c);

    return s;
  }

  @Override
  public String updateStudent(Student s) {
    Student studentUpdate = searchStudent(s.getRoll());
    if (studentUpdate == null) {
      return "Strudent Not Found.";
    }
    col.updateOne(
      Filters.eq("roll", s.getRoll()),
      Updates.combine(
        Updates.set("name", s.getName()),
        Updates.set("course", s.getCourse()),
        Updates.set("marks", s.getMarks()),
        Updates.set("city", s.getCity())
      )
    );
    return "Student Records Updated Successfully.";
  }

  @Override
  public String deleteStudent(int roll) {

    Student student = searchStudent(roll);
    if (student == null) {
      return "Student Not Found.";
    }

    col.deleteOne(Filters.eq("roll", roll));

    return "Student Deleted Successfully.";
  }

  @Override
  public List<Student> listAllStudents() {

    List<Student> studentList = new ArrayList<>();

    for (Document doc: col.find()) {
      Student s = new Student();
      s.setRoll(doc.getInteger("roll"));
      s.setName(doc.getString("name"));
      s.setMarks(doc.getInteger("marks"));
      s.setCity(doc.getString("city"));
      s.setCourse(Course.valueOf(doc.getString("course")));

      studentList.add(s);
    }

    return studentList;
  }

  @Override
  public List<Student> listStudentsByCourse(String course) {
    List<Student> studentList = new ArrayList<>();

    for (Document doc: col.find(Filters.eq("course", course))) {
      Student s = new Student();
      s.setRoll(doc.getInteger("roll"));
      s.setName(doc.getString("name"));
      s.setMarks(doc.getInteger("marks"));
      s.setCity(doc.getString("city"));
      s.setCourse(Course.valueOf(doc.getString("course")));

      studentList.add(s);
    }

    return studentList;
  }

  @Override
  public List<Student> listTopStudents(int limit) {
    List<Student> studentList = new ArrayList<>();

    for (Document doc: col.find().sort(Sorts.descending("marks")).limit(limit)) {
      Student s = new Student();
      s.setRoll(doc.getInteger("roll"));
      s.setName(doc.getString("name"));
      s.setMarks(doc.getInteger("marks"));
      s.setCity(doc.getString("city"));
      s.setCourse(Course.valueOf(doc.getString("course")));

      studentList.add(s);
    }

    return studentList;
  }
}
