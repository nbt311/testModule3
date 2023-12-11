package com.example.testmodule3.controller;

import com.example.testmodule3.entity.ClassRoom;
import com.example.testmodule3.entity.Student;
import com.example.testmodule3.model.StudentDAO;
import com.example.testmodule3.model.StudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class StudentController {
    protected StudentDAO studentDAO;

    public StudentController() {
        this.studentDAO = new StudentModel();
    }

    public void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Student> list;
        if (keyword == null) {
            list = studentDAO.getAllStudent();
        }else{
            list = studentDAO.findStudentByName(keyword);
        }
        req.setAttribute("keyword",keyword);
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/list.jsp");
        dispatcher.forward(req, resp);
    }

    public void showFormAddStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClassRoom> className = studentDAO.getClassRoomNames();
        req.setAttribute("className",className);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/add.jsp");
        dispatcher.forward(req, resp);
    }

    public void addStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int classRoomId = Integer.parseInt(req.getParameter("class"));
        Student student = new Student(name, dateOfBirth, email,address,phone,classRoomId);
        studentDAO.addStudent(student);
        resp.sendRedirect("/student");
    }

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        studentDAO.deleteStudent(id);
        resp.sendRedirect("/student");
    }

    public void showFormEditStudent(HttpServletRequest req, HttpServletResponse resp) throws  ServletException,IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentDAO.findStudentById(id);
        req.setAttribute("student",student);
        List<ClassRoom> className = studentDAO.getClassRoomNames();
        req.setAttribute("className",className);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/edit.jsp");
        dispatcher.forward(req, resp);
    }

    public void editStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateOfBirth"));
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String classroom = req.getParameter("classRoom");
        Student student = new Student(id,name,dateOfBirth,email,address,phone,classroom);
        studentDAO.editStudent(student);
        System.out.println(student);
        List<Student> list =  studentDAO.getAllStudent();
        req.setAttribute("list",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(req,resp);
    }
}
