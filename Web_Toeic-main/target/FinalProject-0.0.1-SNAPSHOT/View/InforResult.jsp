<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script>
	function change(x) {
		if (x == 1) {
			document.getElementById("update-info").style.display = "block";
			document.getElementById("change-password").style.display = "none";
			document.getElementById("header-edit").innerHTML = "CẬP NHẬT THÔNG TIN";
			document.getElementById("change-password1").classList
					.remove("active");
			document.getElementById("update-info1").classList.add("active");

		} else if (x == 2) {
			document.getElementById("update-info").style.display = "none";
			document.getElementById("change-password").style.display = "block";
			document.getElementById("header-edit").innerHTML = "ĐỔI MẬT KHẨU";
			document.getElementById("change-password1").classList.add("active");
			document.getElementById("update-info1").classList.remove("active");
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
									<li><a href="Profile">Thông tin cá nhân</a></li>
									<li class="active-link"><a href="InforResult"> Kết quả
											thi</a></li>
									<li><a href="LogoutController"> Đăng xuất</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="edit-profile">
							<table>
								<thead>
									<tr style="font-weight: 600;" id="header-table">
										<th>Mã đề thi</th>
										<th>Điểm</th>
										<th>Thời gian nộp bài</th>
									</tr>
								</thead>
								<c:forEach items="${listResult }" var="a">
									<tr>
										<td>${a.getExam_id() }</td>
										<td>${a.getResult_score() }</td>
										<td>${a.getResult_time() }</td>
									</tr>

								</c:forEach>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>