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
        <div class="page-header">
            <h1>Create User <small>from Test Application</small></h1>
        </div>
        <ol class="breadcrumb">
            <li><a href="index.jsp">Index</a></li>
            <li><a href="addUser.jsp">Create User</a></li>
        </ol>
        <div class="alert alert-success" role="alert"><strong>Success</strong>You successfully created a new user.</div>
        <a href="index.jsp" class="btn btn-default btn-lg" role="button">Back to main page</a>
        <a href="/manageUser?action=add" class="btn btn-primary btn-lg" role="button">Create new one</a>
    </div>
</div>
</body>
</html>
