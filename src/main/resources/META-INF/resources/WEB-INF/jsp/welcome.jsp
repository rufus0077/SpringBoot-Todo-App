<html>
	<head>
		<title>welcome page</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container">
            <h1>
                welcome ${name}
            </h1>

            <hr>
            <div><a href="list-todos">Manage</a> your todos</div>

    </div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>