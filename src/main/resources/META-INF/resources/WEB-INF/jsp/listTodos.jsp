<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">






<html>
	<head>
		<title>List Todos page</title>
	</head>
	<body>
	<div class="container">
                <h1>
                    Your todos
                </h1>
                <table class="table">
                    <thead>
                      <tr>
                        <th>ID</th>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done</th>
                      </tr>
                    </thead>
                        <tbody>
                            <c:forEach items="${todos}" var="todo">
                                <tr>
                                    <td>${todo.id}</td>
                                    <td>${todo.description}</td>
                                    <td>${todo.targetDate}</td>
                                    <td>${todo.done}</td>
                                </tr>
                            </c:forEach>
                         </tbody>
                </table>

                <a href="add-todo" class="btn btn-success">Add todo</a>

		</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>

	</body>
</html>