<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>


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

<script type="text/javascript">
	function checkEmail() {// Kiểm tra email đúng chuẩn chưa
		var email = document.getElementById("email").value;
		var emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!emailformat.test(email) || email == "") {
			document.getElementById("errorEmail").innerHTML = "Email không hợp lệ";
			return false;

		} else {
			document.getElementById("errorEmail").innerHTML = null;
			return true;
		}
	}
	
</script>





</head>

<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->
	<div class="form-login">
		<div class="row">
			<div class="col-sm-6">
				<div class="img-login">
					<img src="codes/img/login2.png" alt="">
				</div>
			</div>
			<div class="col-sm-6">
				<div class="login-register">
					<div class="form" id="login">
						<div class="header-form">
							<h4>Quên Mật Khẩu</h4>
							<span>Nhập email đăng kí tài khoản của bạn.</span>
						</div>
						<div class="error">
						<p>${messFail}</p>
						</div>
						<div class="success">
						<p>${mess}</p>
						</div>
						<form method="POST" action="ForgetPassword" onsubmit="return checkLogin()">
							<div id="errorEmail" class="error"></div>
							<input class="form-control" type="text" name="email"
								id="email" onkeyup="checkEmail()" placeholder="Email đăng kí"
								required="">
							<div class="form-button">
								<button id="submit" type="submit" class="ibtn">Lấy lại mật khẩu</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- /.main-container -->

	<jsp:include page="Footer.jsp"></jsp:include>



</body>
</html>