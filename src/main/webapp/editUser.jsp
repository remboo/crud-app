<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Test App | Create User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css?v=3.3.7"/>
    <link rel="stylesheet" type="text/css" href="css/style.css?v=0.0.1"/>
    <script type="text/javascript" src="js/index.js?v=0.0.1"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Edit User <small>for Test Application</small></h1>
        </div>
        <ol class="breadcrumb">
            <li><a href="index.jsp">Index</a></li>
            <li class="active">Edit User</li>
        </ol>
        <!-- <h2>Edit User</h2> -->
        <form method="POST" action="/manageUser?action=update" class="form-horizontal col-sm-8">
            <div class="form-group">
                <label for="id" class="col-sm-4 col-md-4 control-label">Id</label>
                <div class="col-sm-8">
                    <input type="text" name="id" value="${user.id}" readonly="true" class="form-control" />

                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-4 col-md-4 control-label">First Name</label>
                <div class="col-sm-8">
                    <input type="text" name="name" value="${user.name}" placeholder="First Name" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label for="surname" class="col-sm-4 col-md-4 control-label">Last Name</label>
                <div class="col-sm-8">
                    <input type="text" name="surname" value="${user.surname}" placeholder="Last Name" class="form-control" />
                </div>
            </div>
            <div class="form-group">
                <label for="year" class="col-sm-4 col-md-4 control-label">Year</label>
                <div class="col-sm-8">
                    <input type="text" name="year" value="${user.year}" placeholder="Year" class="form-control"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10 col-md-4">
                    <button type="submit" class="btn btn-primary btn-lg">Edit</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>