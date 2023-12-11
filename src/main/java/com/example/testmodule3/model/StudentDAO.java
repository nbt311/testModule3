package com.example.testmodule3.model;

import com.example.testmodule3.entity.ClassRoom;
import com.example.testmodule3.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudent();
    void addStudent(Student student);
    Student findStudentById(int id);
    List<Student> findStudentByName(String keyword);
    void editStudent(Student student);
    void deleteStudent(int id);
    List<ClassRoom> getClassRoomNames();
}
