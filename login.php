<?php
  require "init.php";

  $name="cedric";
  $password="cedric132";
  $contact="0603935292";
  $country="Cameroon";
  $sql = "SELECT name FROM users WHERE name LIKE '$name' AND password LIKE '$password';";

  $result = mysqli_query($conn, $sql);

  if(mysqli_num_rows($result)){
   $row = mysqli_fetch_assoc($result);
   $name = $row['name'];
   echo "$name";
  }else{
    echo "error";
  }
     
?>