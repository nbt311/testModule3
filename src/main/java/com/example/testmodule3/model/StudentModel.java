package com.example.testmodule3.model;

import com.example.testmodule3.database.Database;
import com.example.testmodule3.entity.ClassRoom;
import com.example.testmodule3.entity.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentModel implements StudentDAO{
    protected Connection conn;

    public StudentModel() {
        Database database = Database.getInstance();
        this.conn = database.connection();
    }


    @Override
    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        try {
            String sql = "SELECT s.id, s.name, s.dateOfBirth, " +
                    "s.email, s.address,s.phone, " +
                    "c.name FROM students s JOIN classroom c ON c.id = s.classRoomId ORDER BY s.id";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String className = rs.getString(7);
                Student student = new Student(id,name,dateOfBirth ,email, address, phone, className);
                list.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return list;
    }

    @Override
    public void addStudent(Student student) {
        try {
            String sql = "INSERT INTO students(name, dateOfBirth,email,address,phone,classRoomId) VALUES (?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, student.getName());
            stmt.setDate(2, Date.valueOf(student.getDateOfBirth()));
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getAddress());
            stmt.setString(5, student.getPhone());
            stmt.setInt(6, student.getClassRoomId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
    }

    @Override
    public Student findStudentById(int id) {
        Student student = null;
        try {
            String sql = " SELECT s.id,s.name, s.dateOfBirth, s.email, s.address, s.phone,s.classRoomId ,c.name FROM students s JOIN classroom c on s.classRoomId = c.id WHERE s.id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                int classRoomId = rs.getInt(7);
                String classRoomName = rs.getString(8);
                student = new Student(name,dateOfBirth,email,address,phone,classRoomId,classRoomName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return  student;
    }

    @Override
    public List<Student> findStudentByName(String keyword) {
        List<Student> students = new ArrayList<Student>();
        try {
            String sql = "SELECT s.id, s.name, s.dateOfBirth, s.email, s.address, s.phone, c.name FROM students s JOIN classroom c ON c.id = s.classRoomId WHERE s.name LIKE ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"%" + keyword + "%");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                LocalDate dateOfBirth = rs.getDate(3).toLocalDate();
                String email = rs.getString(4);
                String address = rs.getString(5);
                String phone = rs.getString(6);
                String classroom = rs.getString(7);
                Student student = new Student(id,name,dateOfBirth,email,address,phone,classroom);
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return  students;
    }

    @Override
    public void editStudent(Student student) {
        try {
            String sql = "UPDATE students JOIN classroom ON students.classRoomId = classroom.id SET students.name = ?, students.dateOfBirth = ?, students.email = ?, students.address = ?, students.phone = ?, students.classRoomId = ? WHERE students.id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println("SQL: " + sql);
            statement.setString(1,student.getName());
            statement.setDate(2, Date.valueOf(student.getDateOfBirth()));
            statement.setString(3,student.getEmail());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setInt(6,student.getClassRoomId());
            statement.setInt(7,student.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
    }

    @Override
    public void deleteStudent(int id) {
        try {
            String sql = "DELETE FROM students WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
    }
    public List<ClassRoom> getClassRoomNames() {
        List<ClassRoom> roomNames = new ArrayList<>();
        try {
            String sql = "SELECT * FROM classroom";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                ClassRoom room = new ClassRoom(id, name);
                roomNames.add(room);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "Error");
        }
        return roomNames;
    }
}
