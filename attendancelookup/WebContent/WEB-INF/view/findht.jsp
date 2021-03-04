
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
<title>Find Attendance</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
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
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<%-- <li class="current"><a href="${pageContext.request.contextPath}/attendancefind">FindAttendance</a></li> --%>
					<li><a href="logout">logout</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<section id="showcase">
		<div class="container">
			<h1>Join The Force</h1>
			<!--  <h2><a href="${findermodel.pdfLink}" target="_blank">${findermodel.hallticket}</a></h2>-->
			<div class="htkt">
				<h1>
					<span class="ht">Enter Hallticket</span></span>
				</h1>
			</div>
			<form:form action="findpdf" modelAttribute="findermodel"
				method="post">
				<div class=input>
					<form:input path="hallticket"
						placeholder="Enter Hallticket number..." minlength="19"
						maxlength="19"></form:input>
				</div>
				<div class="submit">
					<button type="submit" class="button_1">Submit</button>
			</form:form>
		</div>
		</div>
	</section>

	<section id="newsletter">
		<div class="container">
			<!--  <h1>Enter Hall ticket</h1></div>-->
			<div class="link">
				<h2>${findermodel.message}<a href="${findermodel.pdfLink}"
						target="_blank">${findermodel.hallticket}</a>
				</h2>
			</div>
			<!-- <form:form action="findpdf" modelAttribute="findermodel" method="post">
         <div class=input><form:input path="hallticket" placeholder="Enter Hallticket number..."></form:input></div>
          <div class="submit"><button type="submit" class="button_1">Submit</button>
        </form:form>-->

		</div>
	</section>


	<footer>
		<p>C-DAC,Copyright &copy; 2019</p>
	</footer>
</body>
</html>
