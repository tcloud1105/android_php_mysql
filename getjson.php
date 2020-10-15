<?php
  require "init.php";

  $sql = "SELECT * FROM users;";
  
  $result = mysqli_query($conn, $sql);
  $response = array();

  while($row = mysqli_fetch_array(result)){
      array_push($response, array("name"=>$row[0],"email"=>$row[1], "contact"=>$row[2], "password"=>$row[3]));
  }

  echo json_encode(array("server_response"=>$response));// open jsonlint to view the json object in fashion manner
 mysqli_close($conn);
?>