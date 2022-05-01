<%-- 
    Document   : index
    Created on : Apr 26, 2022, 3:34:15 PM
    Author     : iracl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>European Dynamics e-commerce</title>
        <link rel="stylesheet" href="./css/style.css" />

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>  

    </head>


    <body>
        <div>
            <img src="./images/codehub.png"> <br />
            <a href=".">  European Dynamics e-commerce App </a>

        </div>
        <br /> <br />
        <div  class="collapse navbar-collapse" id="myNavbar">     
            <ul class="nav navbar-nav">

                <li class="navlink"><a href="javascript:askPing()">Ping0</a></li>
                <li class="navlink"><a href="./api/employee">Employees</a></li>
                <li class="navlink"><a href="./login.html">login</a></li>
                <li class="navlink"><a href="./CreateEmployee.html">Create an employee</a></li>

                <li class="navlink"><a href="./index.jsp?page=index"  >get Employee</a></li>
                <li class="navlink"><a href="#" onclick="logout()">logout</a></li>
            </ul>

        </div>
        <br /> <br />
        <%
            String pager = request.getParameter("page");
            String fileName = "/include/common/getEmployee.jspf";

            if (pager == null) {
                    ;
            } else if (pager.equals("index")) {
        %>   <jsp:include page="<%= fileName%>" flush="true" />  <%
            }
        %>



        <script>
            function    askPing()
            {
                var url = "http://localhost:8080/ed-app/api/ping"
                var method = "GET"

                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        returnValue = this.responseText
                        document.getElementById("results").innerHTML = JSON.stringify(returnValue);
                    }
                };
                xmlhttp.open(method, url, true);
                xmlhttp.send();
            }



            function getCustomer() {
                url = "http://localhost:8080/ed-app/api/employee/" + document.getElementById("employeeId").value
                window.open(url, "_self");
            }

            function logout() {
                localStorage.removeItem("username")
                localStorage.removeItem("password")
                alert("you are unlogged")
            }


        </script>
        <div id="results"></div>

        <div id="footer">
            <%@ include file="/include/common/footer.jspf" %>
        </div>

    </body>
</html>
