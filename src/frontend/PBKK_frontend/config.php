<?php
define('DBSERVER', 'localhost');
define('DBUSERNAME','root');
define('DBPASSWORD', '');
define('DBNAME', 'customer-svc');

$connect = mysqli_connect(DBSERVER, DBUSERNAME, DBPASSWORD, DBNAME);

if($connect == FALSE) {
    die("ERROR: Could not connect. " . mysqli_connect_error());
}

else {
    print("Success");
}

?>