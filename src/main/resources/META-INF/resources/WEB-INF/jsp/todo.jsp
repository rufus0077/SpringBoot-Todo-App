<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h1>Enter Todo details</h1>

    <c:url var="actionUrl" value="${empty todo.id || todo.id == 0 ? 'add-todo' : 'update-todo'}" />
    <form:form method="post" action="${actionUrl}" modelAttribute="todo">
            <fieldset class='mb-3'>
                <form:label path="description">Description:</form:label>
                <form:input type="text" path="description" required="required" cssClass="form-control" />
                <form:errors path="description" cssClass="text-danger" />
            </fieldset>
            
            <fieldset class='mb-3'>
                <form:label path="targetDate">Target Date:</form:label>
                <form:input type="text" path="targetDate" cssClass="form-control datepicker" required="required" />
                <form:errors path="targetDate" cssClass="text-danger" />
            </fieldset>

        <form:errors path="description" cssClass="text-danger" />
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="userName" />
        <form:input type="hidden" path="done" />

        <input type="submit" value="Submit" class="btn btn-success" />
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.10.0/js/bootstrap-datepicker.min.js"></script>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>

</body>
</html>
