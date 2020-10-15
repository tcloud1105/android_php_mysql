<?php 
$db_name="project";
$mysql_user="root";
$db_password="";
$server_name="localhost";

$conn = mysqli_connect($server_name, $mysql_user, $db_password, $db_name);


if(!$conn){
  return "connection not successful";
}else{
    return "connection successful";
}

?>