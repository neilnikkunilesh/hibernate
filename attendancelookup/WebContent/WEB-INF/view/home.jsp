
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
					<li><a
						href="${pageContext.request.contextPath}/attendancefind">FindAttendance</a></li>
					
					<li><a
						href="logout">logout</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<section id="showcase">
		<div class="container">
			<h1>Join The Force</h1>
			<%-- <p>${hallticket}</p> --%>
			<p></p>
		</div>
	</section>

	<section id="newsletter">
		<div class="container">
			<%--    <h1>Enter Hall ticket</h1>
        <form:form action="findpdf" method="post">
          <form:input path="hallticket" placeholder="Enter Hallticket number..."></form:input>
          <button type="submit" class="button_1">Submit</button>
        </form:form> --%>
		</div>
	</section>


	<footer>
		<p>C-DAC,Copyright &copy; 2019</p>
	</footer>
</body>
</html>
