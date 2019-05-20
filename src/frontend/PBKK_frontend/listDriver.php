<?php

include_once("config.php");

$result = mysqli_query($mysqli, "SELECT * FROM driver ORDER BY id ASC");
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Driver List</title>
</head>
<body>
<table width='80%' border=1>
    <tr>
        <th>Nama Lengkap</th> <th>Alamat</th> <th>Identitas</th> <th>Email</th> <th>Password</th> <th>Jenis Kendaraan</th> <th>No.Polisi</th> <th>Status</th> <th>Update</>
    </tr>
    <?php
        while($user_data = mysqli_fetch_array($result)) {
            echo"<tr>";
            echo"<td>".$user_data['namalengkap']."</td>";
            echo"<td>".$user_data['alamat']."</td>";
            echo"<td>".$user_data['noidentitas']."</td>";
            echo"<td>".$user_data['email']."</td>";
            echo"<td>".$user_data['password']."</td>";
            echo"<td>".$user_data['jeniskendaraan']."</td>";
            echo"<td>".$user_data['nopolisi']."</td>";
            echo"<td>".$user_data['status']."</td>";
            echo "<td><a href='edit.php?id=$user_data[id]'>Edit</a> | <a href='delete.php?id=$user_data[id]'>Delete</a></td></tr>";
        }
    ?>
    
    
</body>
</html>