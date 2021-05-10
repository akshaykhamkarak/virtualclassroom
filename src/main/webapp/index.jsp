<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Welcome-page</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>virtual-class</title>

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">
 
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/panel.css">
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="js/modernizr.custom.js"></script>
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

  <nav id="menu" class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
          data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span
            class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <a class="navbar-brand page-scroll" href="#page-top"> <i class="fa fa-university"></i> VIRTUAL-CLASS</a>
      </div>


      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#page-top" class="page-scroll">Home</a></li>
          <li><a href="#services" class="page-scroll">News</a></li>

          <li> <a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
          <button class="btn btn-default" data-toggle="modal" data-target="#myModal2">registration</button>
        </ul>
      </div>

    </div>
  </nav>

  <header id="header">
    <div class="intro text-center">
      <div class="overlay">
        <div class="container">
          <div class="row">
            <div class="intro-text">
              <h1>Welcome to<span class="brand">VIRTUAL-CLASS</span></h1>

              <a href="#services" class="btn btn-default btn-lg page-scroll">READ MORE</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </header>

  <div id="services" class="intro text-center">
    <div class="container">
      <div class="col-md-8 col-md-offset-2 section-title">
        <h2>News</h2>
        <p>Following technologies used to complete final year.</p>
       
      </div>

    </div>
  </div>
  </div>



  <!-- Modal -->

  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
      <div class="modal-body">

        <div class="login-box" style="margin-top: 200px;">
          <h2>LOGIN</h2>
          <form action="login" method="post">
            <div class="user-box">
              <input type="text" name="username" id="username" required="">
              <label>Username</label>
            </div>
            <div class="user-box">
              <input type="password" name="password" id="password" required="">
              <label>Password</label>
            </div>


            <button type="submit" class="btn btn-default pull-left" name="add" >LOGIN</button>

            <button type="submit" class="btn btn-default pull-right" name="close" data-dismiss="modal">CLOSE</button>
          </form>
          <br><br><br>
          <p href="#" style="color:#fff; cursor: pointer; float: left;" data-toggle="modal" data-target="#forgot">forgot
            password?</p>

        </div>
      </div>
    </div>
  </div>


  <div class="modal fade" id="myModal2" role="dialog" style="margin-top: 100px;">
    <div class="modal-dialog">

      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">new registration</h4>
        </div>
        <div class="modal-body">
        <!-- Registration form  -->
          <form class="form-horizontal" action="reg" method="post">
         
            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">name<span style="color: red;"><big>*</big></span> </label>
                <input type="text" class="form-control" id="name" placeholder="Enter Name" name="rname">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">city<span style="color: red;"><big>*</big></span> </label>
                <input type="text" class="form-control" id="city" placeholder="Enter city" name="rcity">
              </div>
            </div>

             <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">City pin <span style="color: red;"></span></label>
                <input type="number" class="form-control" id="rcitypin" placeholder="Enter pin" name="rcitypin">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">Mobile Number <span style="color: red;"></span></label>
                <input type="Number" class="form-control" id="number" placeholder="Enter Mobile Number" name="rnumber" required="required">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">Address</Address><span
                      style="color: red;"><big>*</big></span> </label>
                <input type="text" class="form-control" id="address" placeholder="Enter address" name="raddress">
              </div>
            </div>

  			<div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">Email<span style="color: red;"><big>*</big></span>
                </label>
                <input type="text" class="form-control" id="uname" placeholder="Email" name="remail">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">user-name<span style="color: red;"><big>*</big></span>
                </label>
                <input type="text" class="form-control" id="uname" placeholder="Username" name="rusername">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">
                <label class="col-sm-6 " style="color: #000;">password<span style="color: red;"><big>*</big></span>
                </label>
                <input type="text" class="form-control" id="Password" placeholder="password" name="rpassword">
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-12">

                <span style="color:#000;">Choose option</span><br>
                <input type="radio" name="category" value=2><span style="color:#000;">&nbsp; Staff</span><br>
                <input type="radio" name="category" value=3><span style="color:#000;">&nbsp; Student</span><br>


              </div>
            </div>


            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
            <button type="submit" class="btn btn-success pull-right">registration</button>
            <br>
          </form>

        </div>

      </div>

    </div>
  </div>



  <!-- Modal -->
  <div id="forgot" class="modal fade" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">forgot password</h4>
        </div>
        <div class="modal-body">
          <label class="col-sm-6 " style="color: #000;">Email<span style="color: red;"><big>*</big></span> </label>
          <input type="text" class="form-control" id="name" placeholder="Enter email id" name="metar">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-dismiss="modal">submit</button>
        </div>
      </div>

    </div>
  </div>



  <div id="footer">
    <div class="container text-center">
      <div class="fnav">
        <p>virtual-classroom-2020<a href="#" rel="nofollow">|mindtree</a></p>
      </div>
    </div>
  </div>

  <script>
    function deletePost() {
      var ask = window.confirm("confirm your recharge..?");
      if (ask) {
        window.alert("this service is temporarily unavailable! Thank you...");

        window.location.href = "index.html";

      }
    }
  </script>


  <script type="text/javascript" src="js/jquery.1.11.1.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/SmoothScroll.js"></script>
  <script type="text/javascript" src="js/jqBootstrapValidation.js"></script>
 <!-- <script type="text/javascript" src="js/contact_me.js"></script>-->
  <script type="text/javascript" src="js/main.js"></script>




  <script>

    function login() {
      var user = document.getElementById("username").value;
      var pass = document.getElementById("password").value;



      if (user == "admin" && pass == "admin") {
        document.location.href = "./admin/index.html";

        localStorage.setItem("firstname", user);
        return false;
      }
      else if (user != "" && pass != "") {
        window.alert("Wrong value");

        console.log("No such document!");

      }




    }
  </script>
</body>
</html>