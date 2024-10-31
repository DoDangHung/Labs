<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>


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

<!-- reCaptcha google -->
<script type="text/javascript">
      var onloadCallback = function() {
        grecaptcha.render('html_element', {
          'sitekey' : '6LfqI6UZAAAAAGGI1KPn7lVWNejMNftLz-mOYSRf'
        });
      };
      var correctCaptcha = function(response) {
    	  document.getElementById("submit").disabled=false;
      };
    </script>
    
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer>
    </script>

<script>
        function change(i) {
            if (i == 1) {
                document.getElementById("login").style.display = "block";
                document.getElementById("register").style.display = "none";
                document.getElementById("register-chose").classList.remove("active");
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
	<div class="form-login">
		<div class="row">
			<div class="col-sm-6">
				<div class="img-login">
					<img src="codes/img/login2.png" alt="">
				</div>
			</div>
			<div class="col-sm-6">
				<div class="login-register">
					
					<div class="form" id="register">
						<div class="header-form">
							<h4>Tạo tài khoản</h4>
							<span>Tạo tài khoản để có thể nhận thông báo và thi thử
								miễn phí.</span>
						</div>
						<div class="link-chose">
							<ul>
								<li><a href="Login" 
									id="login-chose">ĐĂng nhập</a></li>
								<li><a class="active" href="#" id="register-chose">đăng
										kí</a></li>
							</ul>
						</div>
						<div class="error">${message}</div>
						<div class="success	">${success}</div>
						<form method="POST" action="#" onsubmit="return checkbuttonReg()"
							name="myForm">
							<div id="errorName" class="error"></div>
							<input class="form-control" type="text" name="name" id="name"
								onkeyup="checknameReg()" placeholder="Họ tên" required="" maxlength="45" pattern="[A-Za-z+ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$">
							<div id="errorUser_reg" class="error"></div>
							<input class="form-control" type="text" name="memberuser_reg"
								id="username_reg" onkeyup="checkuserReg()"
								placeholder="Tên tài khoản" required="" maxlength="20" pattern="[A-Za-z0-9]+$">
							<div id="errorEmail" class="error"></div>	
							<input class="form-control" type="email" name="memberemail"
								onkeyup="checkemailReg()" placeholder="Email" required="">
							<div id="errorPass_reg" class="error"></div>
							<input class="form-control" type="password" name="memberpass_reg"
								id="pass_reg" onkeyup="checkpassReg()" placeholder="Mật khẩu"
								required="" maxlength="20">
							<div id="errorPass1_reg" class="error"></div>
							<input class="form-control" type="password"
								name="memberpass1_reg" id="pass1_reg" onkeyup="checkpass1Reg()"
								placeholder="Xác nhận mật khẩu" required="">
							<div class="form-button">
							<div id="html_element" data-callback="correctCaptcha"></div>
								<button id="submit" type="submit" disabled="true" class="ibtn">Đăng kí</button>
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