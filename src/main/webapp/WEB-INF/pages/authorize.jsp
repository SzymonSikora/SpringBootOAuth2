
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Get Employees</title>
</head>
<body>
<h3 >Get Employee Info</h3>
<div id="getEmployees">
    <form:form action="http://localhost:8080/oauth/token"
               method="post">
    <p>
        <label>Enter Employee Id</label>
        <input type="text" name="response_type" value="code" />
        <input type="text" name="client_id" value="client1" />
        <input type="text" name="redirect_uri" value="http://localhost:8080/api/admin/account/getOneById?ID=1" />
        <input type="text" name="scope" value="read" />
        <input type="SUBMIT" value="Get account" />
        </form:form>
</div>
</body>
</html>