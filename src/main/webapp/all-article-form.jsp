<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>My Articles</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="container mt-4">
    <h2 style="text-align: center">All Articles</h2>
    <a href="<%=request.getContextPath()%>/user/article" class="btn btn-info float-start mb-2">Back</a>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th style="background-color: lime">Article Title</th>
            <th style="background-color: lime">Article Content</th>
            <th style="background-color: orangered">Author</th>
            <th style="background-color: orangered">Date</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="article" items="${allArticleList}">
            <tr>
                <td><c:out value="${article.title}" /></td>
                <td><c:out value="${article.article}" /></td>
                <td style="background-color: black; color: cyan"><c:out value="${article.username}" /></td>


                <td><c:out value="${article.updatedAt}"/></td>


                <td>
                    <c:choose>
                        <c:when test="${article.username eq sessionScope.username}">
                            <a href="<%=request.getContextPath()%>/user/article/actions?action=edit&id=<c:out value='${article.id}'/>" class="btn btn-warning">Edit</a>
                            <a href="<%=request.getContextPath()%>/user/article/actions?action=delete&id=<c:out value='${article.id}'/>" class="btn btn-danger">Delete</a>
                        </c:when>


                    </c:choose>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br> <br>
</div>

</body>
</html>
