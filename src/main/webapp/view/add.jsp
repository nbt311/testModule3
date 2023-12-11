
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Student</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/addStudent.css">
</head>
<body>
<div class="container h-100">
    <div class="row h-100">
        <div class="col-sm-10 col-md-8 col-lg-6 mx-auto d-table h-100">
            <div class="d-table-cell align-middle">
                <div class="text-center mt-4">
                    <h1 class="h2">Add Student</h1>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="m-sm-4">
                            <form method="post">
                                <div class="form-group">
                                    <label>Name</label>
                                    <input class="form-control form-control-lg" type="text" name="name" placeholder="Enter name">
                                </div>
                                <div class="form-group">
                                    <label>Email address</label>
                                    <input class="form-control form-control-lg" type="email" name="email" placeholder="Enter email">
                                </div>
                                <div class="form-group">
                                    <label>Date Of Birth</label>
                                    <input class="form-control form-control-lg" type="date" name="dateOfBirth" placeholder="Enter date of birth as DD/MM/YYYY">
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <input class="form-control form-control-lg" type="text" name="address" placeholder="Enter student address">
                                </div>
                                <div class="form-group">
                                    <label>Phone</label>
                                    <input class="form-control form-control-lg" type="text" name="phone" placeholder="Enter student phone">
                                </div>
                                <div class="form-group">
                                    <label>Class</label>
                                    <select class="form-control form-control-lg" name="class" required>
                                        <option value="">Open this select menu</option>
                                        <c:forEach items="${className}" var="className">
                                            <option value="${className.getId()}">${className.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="text-center mt-3">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
