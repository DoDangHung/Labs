<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 Không Tìm Thấy Trang</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="codes/css/style.css" rel="stylesheet" />
<script src="codes/js/main.js"></script>

<script>
	function change(i) {
		if (i == 1) {
			document.getElementById("login").style.display = "block";
			document.getElementById("register").style.display = "none";
			document.getElementById("register-chose").classList
					.remove("active");
			document.getElementById("login-chose").classList.add("active");

		} else if (i == 2) {
			document.getElementById("login").style.display = "none";
			document.getElementById("register").style.display = "block";
			document.getElementById("login-chose").classList.remove("active");
			document.getElementById("register-chose").classList.add("active");
		}
	}
</script>




</head>

<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->
	<div class="form-login" style="margin-top: 100px">
		<div class="row">
			<div class="col-sm-6">
				<div class="img-login">
					<img src="codes/img/404.jpg" alt="">
				</div>
			</div>
			<div class="col-sm-6">
				<div style="margin-top: 100px">
					<h3>KHÔNG TÌM THẤY ĐƯỜNG DẪN</h3>
					
					<span style="margin-top: 30px; ">	Quay trở lại <a style="text-decoration: none" href="HomeController">trang chủ  <i class="fa fa-mail-reply"> </i>	</a></span>
				</div>
				
			</div>
		</div>
	</div>

	<!-- /.main-container -->

	<jsp:include page="Footer.jsp"></jsp:include>



</body>
</html>