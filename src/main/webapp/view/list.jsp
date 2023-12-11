
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student List</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/list.css">
</head>
<body>
<div class="container content-container">
    <nav class="navbar navbar-expand-lg navbar-light">
        <a href="/student?action=add" class="btn btn-primary ml-auto-custom mr-2">Add</a>

        <form class="form-inline my-2 my-lg-0 search-form" method="get">
            <input class="form-control mr-sm-2" type="search" name="keyword" value="${keyword}" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </nav>
    <h2>Student List</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Email</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Class Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="student">
            <tr>
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getDateOfBirth()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getAddress()}</td>
                <td>${student.getPhone()}</td>
                <td>${student.getClassRoomName()}</td>
                <td>
                    <a href="/student?action=edit&id=${student.getId()}" class="btn btn-sm btn-edit">Edit</a>
                    <a onclick="return confirm('Are you sure?')" href="/student?action=delete&id=${student.getId()}" class="btn btn-sm btn-delete ml-2">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
