<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${profile.getHo_ten()}</title>

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
	function change(x) {
		if (x == 1) {
			document.getElementById("update-info").style.display = "block";
			document.getElementById("change-password").style.display = "none";
			document.getElementById("header-edit").innerHTML = "CẬP NHẬT THÔNG TIN";

			document.getElementById("update-infor1").style.fontWeight = "700";
			document.getElementById("change-password1").style.fontWeight = "500";

		} else if (x == 2) {
			document.getElementById("update-info").style.display = "none";
			document.getElementById("change-password").style.display = "block";
			document.getElementById("header-edit").innerHTML = "ĐỔI MẬT KHẨU";

			document.getElementById("update-infor1").style.fontWeight = "500";
			document.getElementById("change-password1").style.fontWeight = "700";
		}
	}
</script>

</head>
<body style="background-color: rgba(240, 240, 240, 0.88);">
	<jsp:include page="Header.jsp"></jsp:include>
	<div class="container-wrapper">
		<div class="container">
			<div class="profile-user">
				<div class="row">
					<div class="col-sm-4">
						<div class="profile">
							<div class="info-profile">
								<div class="img-avt">
									<div class="img-inner-avt">
										<img src="codes/img/user.png" alt="">
									</div>
								</div>
								<div class="name-profile">
									<p>${profile.getHo_ten()}</p>
								</div>

							</div>
							<div class="menu-profile">
								<ul>
									<li class="active-link"><a href="Profile">Thông tin cá
											nhân</a></li>
									<li><a href="InforResult"> Kết quả thi</a></li>
									<li><a href="LogoutController"> Đăng xuất</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="edit-profile">
							<div class="edit-info">
								<div class="row"
									style="border-bottom: 1px rgb(230, 230, 230) solid;">
									<div class="col-sm-4">
										<div class="header-edit-form">
											<h4 id="header-edit" style="font-size: 16px">CẬP NHẬT
												THÔNG TIN</h4>
										</div>
									</div>
									<div class="col-sm-8">
										<div class="link-chose float-right" style="margin-top: 0">
											<ul>
												<li><a href="Profile" id="update-infor1">Cập nhật thông
														tin</a></li>
												<li><a href="#" class="active" id="change-password1">Đổi
														mật khẩu</a></li>
											</ul>
										</div>
									</div>

								</div>

								<div class="" id="change-password">
									<div class="form">
										<form action="ChangePassword"
											onsubmit="return checkbutton_change()" name="myForm2"
											method="post">
											<div style="margin-bottom: 5px;">
												<div class="success" style="font-size: 15px">${messPass}</div>
												<div class="error" style="font-size: 15px">${messPassFail}</div>
											</div>
											<h6>Mật khẩu cũ</h6>
											<input name="passold" class="form-control" type="password"
												value="" required>
											<h6>Mật khẩu mới</h6>
											<div id="errorPass" class="error"></div>
											<input name="passnew" class="form-control" type="password"
												value="" onkeyup="checkPass_change()" required>
											<h6>Nhập lại mật khẩu mới</h6>
											<div id="errorPass1" class="error"></div>
											<input name="passnew1" class="form-control" type="password"
												value="" onkeyup="checkPass1_change()" required>
											<div class="form-button">
											<div id="html_element" data-callback="correctCaptcha"></div>
												<button id="submit" type="submit" class="ibtn" disabled="true">Xác
													nhận</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>