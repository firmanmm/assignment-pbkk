<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.css">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Register</title>
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
        <h1>Sign Up</h1>
        <p>Please fill your identity below</p>
        <form action="">
            <div class="formGroup">
                <label for="">Nama Lengkap</label>
                <input type="text" name="username" class="form-control" placehoder="Client ID">

                <label for="">Alamat Lengkap</label>
                <input type="text" name="password" class="form-control">

                <label for="">Nomor Identitas</label>
                <input type="number" name="identitas" class="form-control">

                <label for="">Email</label>
                <input type="text" name="email" class="form-control">

                <label for="">Username</label>
                <input type="text" name="email" class="form-control">

                <label for="">Password</label>
                <input type="password" name="email" class="form-control">
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-primary" value="Sign Up">
            </div>
        </form>
    </div>
    
</body>
</html>