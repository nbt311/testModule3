package com.example.testmodule3.service;

import com.example.testmodule3.controller.StudentController;
import com.example.testmodule3.model.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    protected StudentController studentController;

    @Override
    public void init() throws ServletException {
        this.studentController = new StudentController();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action){
                case "add":
                    studentController.showFormAddStudent(req, resp);
                    break;
                case "edit":
                    studentController.showFormEditStudent(req, resp);
                    break;
                case "delete":
                    studentController.deleteStudent(req, resp);
                    break;
                case "search":
                    studentController.showListStudent(req, resp);
                    break;
                default:
                    studentController.showListStudent(req, resp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action){
                case "add":
                    studentController.addStudent(req, resp);
                    break;
                case "edit":
                    studentController.editStudent(req, resp);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "Error");
        }
    }
}
