<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test App | Error page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=3.3.7"/>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=0.0.1"/>
    <script type="text/javascript" src="js/index.js?v=0.0.1"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Error page <small>of Test Application</small></h1>
        </div>
        <p>${msg}</p>
        <a href="<%=request.getContextPath()%>/manageUser?action=list" class="btn btn-default btn-lg" role="button">Back Home</a>
    </div>
</div>
</body>
</html>