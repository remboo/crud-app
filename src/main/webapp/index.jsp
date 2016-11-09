<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=3.3.7"/>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=0.0.1"/>
    <script type="text/javascript" src="js/index.js?v=0.0.1"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header"></div>
        <div class="jumbotron">
            <h1>Test Application!</h1>
            <br>
            <br>
            <p>
                <a href="/manageUser?action=add" class="btn btn-primary btn-lg" role="button">Add New User</a>
                <a href="/manageUser?action=list" class="btn btn-default btn-lg" role="button">View Users</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>