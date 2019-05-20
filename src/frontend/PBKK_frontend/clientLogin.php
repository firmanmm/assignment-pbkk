<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Client Log In</title>
    <style>
        body {
            padding: 50px;
        }
        .wrapper {
            width: 400px;
            padding: 20px;
        }

        .btn {
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <h1>Log In</h1>
        <p>Please fill client_id and passowrd</p>
        <form action="">
            <div class="formGroup">
                <label for="">Client ID</label>
                <input type="text" name="username" class="form-control" placehoder="Client ID">

                <label for="">Password</label>
                <input type="password" name="password" class="form-control">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Login">
            </div>
        </form>
    </div>
</body>
</html>