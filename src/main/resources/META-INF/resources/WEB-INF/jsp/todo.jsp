<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">

<html>
<head>
    <title>Add Todos page</title>
</head>
<body>
<div class="container">
    <h1>Enter Todo details</h1>

    <form:form method="post" action="add-todo" modelAttribute="todo">
        <div class="mb-3">
            <label>Description:</label>
            <form:input type="text" path="description" required="required" cssClass="form-control" />
        </div>

        <div class="mb-3">
            <label>Target Date:</label>
            <form:input type="date" path="targetDate" cssClass="form-control" />
        </div>
        <form:errors path="description" cssClass="text-danger" />
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="userName" />
        <form:input type="hidden" path="done" />

        <input type="submit" value="Submit" class="btn btn-success" />
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>

</body>
</html>
