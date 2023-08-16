<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<%--    <link rel="stylesheet" href= "css/app.css"/>--%>
    <title>Article APP</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container mt-4">
    <h2 style="text-align: center">List of Articles</h2>
    <div class="text-right">
        <a href="<%=request.getContextPath()%>/user/article/actions?action=viewMyArticles" class="btn btn-info">My articles</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/user/article/actions?action=viewAllArticles" class="btn btn-info">All article</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%=request.getContextPath()%>/user/article/actions?action=new" class="btn btn-warning">Add article</a>
    </div>
    <br>



    <br>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th style="background-color: lime">Article Title</th>
            <th style="background-color: lime">Article Content</th>
            <th style="background-color: orangered">Action</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="article" items="${articles}">
            <tr>
                <td><c:out value="${article.title}" /></td>
                <td><c:out value="${article.article}" /></td>

                <td>
                    <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<c:out value='${article.id}'/>" class="btn btn-warning">Edit</a>
                    <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<c:out value='${article.id}'/>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br> <br>




</div>

</body>
</html>
