
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
    <link rel="stylesheet" href="./resources/css/style.css">
    <style>
    body{
  font: 15px/1.5 Arial, Helvetica,sans-serif;
  padding:0;
  margin:0;
  background-color:#f4f4f4;
}

/* Global */
.container{
  width:80%;
  margin:auto;
  overflow:hidden;
}

ul{
  margin:0;
  padding:0;
}

.button_1{
  height:38px;
  background:#e8491d;
  border:0;
  padding-left: 20px;
  padding-right:20px;
  color:#ffffff;
  cursor: pointer;
}

.dark{
  padding:15px;
  background:#35424a;
  color:#ffffff;
  margin-top:10px;
  margin-bottom:10px;
}

/* Header **/
header{
  background:#35424a;
  color:#ffffff;
  padding-top:30px;
  min-height:70px;
  border-bottom:#e8491d 3px solid;
}

header a{
  color:#ffffff;
  text-decoration:none;
  text-transform: uppercase;
  font-size:16px;
}

header li{
  float:left;
  display:inline;
  padding: 0 20px 0 20px;
}

header #branding{
  float:left;
}

header #branding h1{
  margin:0;
}

header nav{
  float:right;
  margin-top:10px;
}

header .highlight, header .current a{
  color:#e8491d;
  font-weight:bold;
}

header a:hover{
  color:#cccccc;
  font-weight:bold;
}

/* Showcase */
#showcase{
  min-height:400px;
   background: linear-gradient(rgba(255, 99, 71, 0.5), rgba(255,255,255,.2)), url('../img/banner.jpg') no-repeat 100%;
    background-size: cover;
  text-align:center;
  color:#e8491d;
  text-shadow: 2px 2px 4px #000000;
}

#showcase h1{
  font-size:55px;
  margin-bottom:10px;
  
}

#showcase .ht{
  color:#ffffff;
  text-shadow: 2px 2px 4px #000000;
}

/* Newsletter */
#newsletter{
  padding:15px;
  color:#ffffff;
  background:#35424a
}

#newsletter h2{
  float:left;
  }


#newsletter a{
   
 text-align: center;
  color:#e8491d;
}

#showcase form {
  
  margin-top:25px;
}


#showcase .input input{
  padding:5px;
  height:30px;
  width:300px;
  border-radius:3px; 
  
}

/* Boxes */
#boxes{
  margin-top:20px;
}

#boxes .box{
  float:left;
  text-align: center;
  width:30%;
  padding:10px;
}

#boxes .box img{
  width:90px;
  
}

/* Sidebar */
aside#sidebar{
  float:right;
  width:30%;
  margin-top:10px;
}

aside#sidebar .quote input, aside#sidebar .quote textarea{
  width:90%;
  padding:5px;
}

/* Main-col */
article#main-col{
  float:left;
  width:65%;
}

/* Services */
ul#services li{
  list-style: none;
  padding:20px;
  border: #cccccc solid 1px;
  margin-bottom:5px;
  background:#e6e6e6;
}

footer{
  color:#ffffff;
  padding:20px;
  /* margin-top:20px; */
  background-color:#e8491d;
  text-align: center;
}

/* Media Queries */
@media(max-width: 768px){
  header #branding,
  header nav,
  header nav li,
  #newsletter h1,
  #showcase form,
  #boxes .box,
  article#main-col,
  aside#sidebar{
    float:none;
    text-align:center;
    width:100%;
  }

  header{
    padding-bottom:20px;
  }

  #showcase h1{
    margin-top:40px;
  }

  #showcase button, .quote button{
    display:block;
    width:100%;
  }

  #showcase form input[type="string"], .quote input, .quote textarea{
    width:100%;
    margin-bottom:5px;
  }
}
    
    </style>
  </head>
  <body>
    <header>
      <div class="container">
        <div id="branding">
          <h1><span class="highlight">IAF</span> Attendance Lookup</h1>
        </div>
        <nav>
          <ul>
            <li class="current"><a href="${pageContext.request.contextPath}/">Home</a></li>
            <li><a href="${pageContext.request.contextPath}/attendancefind">FindAttendance</a></li>
            <!-- <li><a href="services.jsp">Contact</a></li> -->
          </ul>
        </nav>
      </div>
    </header>

    <section id="showcase">
      <div class="container">
        <h1 style="color:red;text-shadow: 2px 2px 4px #000000;">PLEASE ENTER CORRECT HALL TICKET NUMBER</h1>
        <h2 stle="color:red;text-shadow: 2px 2px 4px #000000;">EITHER INCORRECT HALLTICKET OR CENTRE CODE</h2>
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
