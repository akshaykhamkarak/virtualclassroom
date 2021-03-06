<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="utility.*"%>

<%
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html lang="en">


<head>

<title>SGI - Dashboard</title>
<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->
<!-- start: CSS -->
<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
</head>

<body>
	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a> <a class="brand" href="index.html"><span>Dashboard</span></a>

				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">

						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="halflings-icon white user"></i> <span id="valuel"></span>

						</a> <script>
							document.getElementById("valuel").innerHTML = localStorage
									.getItem("firstname");
						</script>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title"><span>Account
										Settings</span></li>
								<li><a href="#"><i class="halflings-icon user"></i>
										Profile</a></li>
								<li><a href="../index.jsp"><i
										class="halflings-icon off"></i> Logout</a></li>
							</ul></li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->

			</div>
		</div>
	</div>
	<!-- start: Header -->

	<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="index.html"><i class="icon-bar-chart"></i><span
								class="hidden-tablet"> Home</span></a></li>

						<li><a href="../admin/form.html"><i class="icon-user"></i><span
								class="hidden-tablet"> Add Staff/Student</span></a></li>
						<li><a href="studentstaff.jsp"><i class="icon-edit"></i><span>Edit
									Staff-list</span></a></li>
									<li><a href="studentlist.jsp"><i class="icon-edit"></i><span>Edit
									Student-list</span></a></li>
						<li><a href="compalint.html"><i
								class="icon-align-justify"></i><span class="hidden-tablet">Video-Approval</span></a></li>
						<li><a href="feedback.html"><i class="icon-align-justify"></i><span
								class="hidden-tablet">Create-Classroom</span></a></li>
						<li><a href="../index.jsp"><i class="icon-lock"></i><span
								class="hidden-tablet"> Logout</span></a></li>
					</ul>
				</div>
			</div>
			<!-- end: Main Menu -->

			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>
						You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
							target="_blank">JavaScript</a> enabled to use this site.
					</p>
				</div>
			</noscript>

			<!-- start: Content -->
			<div id="content" class="span10">


				<ul class="breadcrumb">
					<li><i class="icon-home"></i> <a href="index.html">Home</a> <i
						class="icon-angle-right"></i></li>
					<li><a href="#">Staff/student</a></li>
				</ul>



				<div class="row-fluid sortable">
					<div class="box span12">
						<div class="box-header">
							<h2>
								<i class="halflings-icon align-justify"></i><span class="break"></span>Staff/Student
								list
							</h2>

						</div>

						<div class="box-content">
							<table class="table table-striped table-bordered text-center">
								<thead>
									<tr>
										<th>Name</th>
										<th>Address</th>
										<th>Email</th>
										<th>PhoneNo</th>
										<th>Post</th>
										<th>Created on</th>
									</tr>
									<%
									try {
										connection = JDBCconnection.getConnection();
										statement = connection.createStatement();
										String sql = "select name,address,email,mobile,postname,Date from userdetails join posttable on userdetails.postid=posttable.postid and userdetails.postid=2";

										resultSet = statement.executeQuery(sql);
										while (resultSet.next()) {
									%>
									<tr bgcolor="#DEB887">
										<td><%=resultSet.getString("name")%></td>
										<td><%=resultSet.getString("address")%></td>
										<td><%=resultSet.getString("email")%></td>
										<td><%=resultSet.getString("mobile")%></td>
										<td><%=resultSet.getString("postname")%></td>
										<td><%=resultSet.getString("Date")%></td>

									</tr>
									<%
									}

									} catch (Exception e) {
									e.printStackTrace();
									}
									%>
								</thead>

								<tbody class="tabeldata"></tbody>
							</table>
						</div>
					</div>
					<!--/span-->
				</div>
				<!--/row-->


			</div>
			<!--/.fluid-container-->

			<!-- end: Content -->
		</div>
		<!--/#content.span10-->
	</div>
	<!--/fluid-row-->


	<!-- start: JavaScript-->

	<script src="js/jquery-1.9.1.min.js"></script>
	<script src="js/jquery-migrate-1.0.0.min.js"></script>

	<script src="js/jquery-ui-1.10.0.custom.min.js"></script>

	<script src="js/jquery.ui.touch-punch.js"></script>

	<script src="js/modernizr.js"></script>

	<script src="js/bootstrap.min.js"></script>

	<script src="js/jquery.cookie.js"></script>

	<script src='js/fullcalendar.min.js'></script>

	<script src='js/jquery.dataTables.min.js'></script>

	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.js"></script>
	<script src="js/jquery.flot.pie.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>

	<script src="js/jquery.chosen.min.js"></script>

	<script src="js/jquery.uniform.min.js"></script>

	<script src="js/jquery.cleditor.min.js"></script>

	<script src="js/jquery.noty.js"></script>

	<script src="js/jquery.elfinder.min.js"></script>

	<script src="js/jquery.raty.min.js"></script>

	<script src="js/jquery.iphone.toggle.js"></script>

	<script src="js/jquery.uploadify-3.1.min.js"></script>

	<script src="js/jquery.gritter.min.js"></script>

	<script src="js/jquery.imagesloaded.js"></script>

	<script src="js/jquery.masonry.min.js"></script>

	<script src="js/jquery.knob.modified.js"></script>

	<script src="js/jquery.sparkline.min.js"></script>

	<script src="js/counter.js"></script>

	<script src="js/retina.js"></script>

	<script src="js/custom.js"></script>




	<script src="js/jquery.js"></script>
	<script src="js/custlist.js"></script>
	<!-- end: JavaScript-->

</body>

</html>