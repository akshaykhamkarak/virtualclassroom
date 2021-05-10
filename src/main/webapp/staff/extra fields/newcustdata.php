<?php

	$conn = new mysqli('localhost', 'root', '', 'sgiprepaidmeter');


	if ($conn->connect_error) {
	    die("Connection failed: " . $conn->connect_error);
	}
	
$check="SELECT * FROM addcust WHERE email = '$_POST[email]'";
$rs = mysqli_query($conn,$check);
$data = mysqli_fetch_array($rs, MYSQLI_NUM);
if($data[0] > 1) {
    echo "User Already in Exists<br/>";
}
else{
	if(isset($_POST['addcust'])){
		$name = $_POST['name'];
		$address = $_POST['address']; 
		$email = $_POST['email'];
		$pincode = $_POST['pincode'];
		$mobile = $_POST['mobile']; 
		$meterno = $_POST['meterno'];
		
		// if(!empty($filename)){
		// 	move_uploaded_file($_FILES['photo']['tmp_name'], 'img/'.$filename);	
		// }

		$sql = "INSERT INTO addcust (name,address,email,pincode,mobile,meterno) VALUES ('$name', '$address', '$email','$pincode', '$mobile', '$meterno')";
		if($conn->query($sql)){
			$_SESSION['success'] = 'Data added successfully';
		}
		else{
			$_SESSION['error'] = $conn->error;
		} 
	}	 
	else{
		$_SESSION['error'] = 'Fill up add form first';
	}
echo "data add successfully";
	header('location:../../ak/admin/index.html');
}
?>  