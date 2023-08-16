<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Form</title>
    <link rel="stylesheet" href= "css/app.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h2 style="text-align: center">User Register Form</h2>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <form action="<%=request.getContextPath()%>/register" method="post">

                <div class="form-group">
                    <label for="name">First Name:</label>
                    <input type="text" class="form-control" id="name" placeholder="First Name" name="name" required>
                </div>

                <br>

                <div class="form-group">
                    <label for="surname">Last Name:</label>
                    <input type="text" class="form-control" id="surname" placeholder="Last Name" name="surname" required>
                </div>

                <br>

                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
                </div>

                <br>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-secondary" href="login.jsp">Login</a>

            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
</body>
</html>