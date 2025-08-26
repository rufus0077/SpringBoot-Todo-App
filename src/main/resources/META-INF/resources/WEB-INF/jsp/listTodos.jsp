<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

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
                        <th></th>
                        <th></th>
                      </tr>
                    </thead>
                        <tbody>
                            <c:forEach items="${todos}" var="todo">
                                <tr>
                                    <td>${todo.id}</td>
                                    <td>${todo.description}</td>
                                    <td>${todo.targetDate}</td>
                                    <td>${todo.done}</td>
                                    <td> <a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a> </td>
                                    <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
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