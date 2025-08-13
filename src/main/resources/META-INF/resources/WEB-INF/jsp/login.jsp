<html>

	<head>
		<title>Login</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/css/bootstrap.min.css">
	</head>
	<body>
	<div class="container">
		<h1>login</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
		    Name: <input type="text" name="name">
            Password: <input type="password" name="password">
            <input type="submit" value="Submit">
		</form>
	</div>
		<script src="${pageContext.request.contextPath}/webjars/jquery/3.7.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>