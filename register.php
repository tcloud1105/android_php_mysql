<?php
  require "init.php";

  $name=$_POST['name'];
  $password=$_POST['password'];
  $contact=$_POST['contact'];
  $country=$_POST['country'];
  $sql = "INSERT INTO users VALUES('$name', '$password', '$contact', '$country');";

  if(mysqli_query($conn, $sql)){
     return "Data inserted";
  }else{
      return "error";
  }
?>