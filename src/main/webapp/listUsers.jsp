<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test App | View Users</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=3.3.7"/>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=0.0.1"/>
    <script type="text/javascript" src="js/index.js?v=0.0.1"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Users <small>from Test Application</small></h1>
        </div>
        <ol class="breadcrumb">
            <li><a href="index.jsp">Index</a></li>
            <li class="active">List of Users</li>
        </ol>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Year</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${model.users}" var="user">
                <tr>
                    <td><a href = "<%=request.getContextPath()%>/manageUser?action=edit&id=${user.id}">${user.id}</a></td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.year}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>