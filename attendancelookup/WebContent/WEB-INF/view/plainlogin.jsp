<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<meta name="description"
	content="IAF Attendance Lookup">
<meta name="keywords"
	content="IAF,Attendance, lookup">
<meta name="author" content="Prabhat singh">
<title>IAF Attendance Finder | Welcome</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<style>
form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}

.failed {
	color: red;
}
</style>
</head>
<body>
	<header>
		<div class="container">
			<div id="branding">
				<h1>
					<span class="highlight">IAF</span> Attendance Lookup
				</h1>
			</div>
			<nav>
				<ul>
					<li class="current"><a
						href="${pageContext.request.contextPath}/">Home</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<section id="showcase">
		<div class="wrapper">

			<form:form class="form-signin"
				action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				<h2 class="form-signin-heading">Please login</h2>
				<input type="text" class="form-control" name="username"
					placeholder="Username" required="" autofocus="" />
				<input type="password" class="form-control" name="password"
					placeholder="Password" required="" />
				<div>
					<!-- Check for Login error -->
					<c:if test="${param.error != null}">
						<p class="failed">username password is incorrect.</p>
					</c:if>

					<!-- Check for Login error -->
					<c:if test="${param.logout != null}">
						<p class="failed">You have been logged out.</p>
					</c:if>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
			</form:form>
		</div>
		<%-- 	<%-- <spring:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>
		<%--<form:form
				action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">
				<div class="container">
					<div>
						<!-- Check for Login error -->
						<c:if test="${param.error != null}">
							<i class="failed">username password is incorrect.</i>
						</c:if>

						<!-- Check for Login error -->
						<c:if test="${param.logout != null}">
							<i class="failed">You have been logged out.</i>
						</c:if>
					</div>
					<label for="username"><b>Username</b></label> <input type="text"
						placeholder="Enter Username" name="username" required> <label
						for="password"><b>Password</b></label> <input type="password"
						placeholder="Enter Password" name="password" required> <input
						type="submit" value="Login" />
				</div>
			</form:form> --%>
	</section>


	<footer>
		<p>C-DAC,Copyright &copy; 2019</p>
	</footer>
</body>
</html>
