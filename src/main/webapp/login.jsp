<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Form</title>
    <link rel="stylesheet" href= "css/app.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
    <h1 style="text-align: center">Login Form</h1>
    <h4 style="text-align: center; color: red">${loginError}</h4>
    <div class="row">
        <div class="col-3"></div>
        <div class="col-6">
            <form action="<%=request.getContextPath()%>/login" method="post">

                <div class="form-group">
                    <label for="username">User Name:</label>
                    <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
                </div>
                <br>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
                </div>

                <br>
                <button type="submit" class="btn btn-primary">Login</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                <a class="btn btn-secondary" href="register.jsp">SignUp</a>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
</body>
</html>