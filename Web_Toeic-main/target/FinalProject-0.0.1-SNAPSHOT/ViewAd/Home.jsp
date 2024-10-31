<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bảng tin</title>

<!-- Font awesome -->

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

<script type="text/javascript"> /* intro loading */
	document.onreadystatechange = function() {
		var state = document.readyState
		if (state == 'interactive') {
			document.getElementById('contents').style.display = "none";
		} else if (state == 'complete') {
			setTimeout(function() {
				document.getElementById('interactive');
				document.getElementById('load').style.display = "none";
				document.getElementById('contents').style.display = "block";
			}, 1000);
		}
	}
</script>

</head>

<body style="background-color: rgb(231, 231, 231);">
	<div id="load"
		class="introLoading introLoader gifLoader theme-dark bubble">
		<div id="introLoaderSpinner" class="gifLoaderInner" style=""></div>
	</div>
	<div class="main-container" id="contents">
		<jsp:include page="Header.jsp"></jsp:include>

		<!-- Menu bên trái trang web -->
		<div class="left-sidebar">
			<div class="side-bar">
				<ul class="side-bar-menu">
					<li><a href="AdminFoward" class="active-menu"><i
							class="fa fa-dashboard" style="font-size: 20px"></i> Bảng Tin</a></li>
					<li><a href="#homeSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-edit" style="font-size: 20px"></i> Bài Viết</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="AdminQuanLiPostFoward?pageid=1#123" id="123"><i
									class="fa fa-th-list"></i> Tất cả bài viết</a></li>
							<li><a href="AdminPostController#124" id="124"><i
									class="fa fa-plus-circle"></i> Thêm bài viết</a></li>
						</ul></li>
					<li><a href="#homeSubmenu1" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-question-circle" style="font-size: 20px;"></i> Đề
							Thi</a>
						<ul class="collapse list-unstyled" id="homeSubmenu1">
							<li><a href="AdminQuanLiExam#125" id="125"><i
									class="fa fa-th-list"></i> Tất cả đề thi</a></li>
							<li><a href="AdminExamController#125" id="125"><i
									class="fa fa-plus-circle"></i> Thêm đề thi</a></li>
						</ul></li>
					<li><a href="#homeSubmenu2" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-users" style="font-size: 20px;"></i> Người dùng</a>
						<ul class="collapse list-unstyled" id="homeSubmenu2">
							<li><a href="AdminUserManager?pageid=1" id="125"><i
									class="fa fa-th-list"></i> Tất cả người dùng</a></li>
							<li><a href="AdminUserManager_ban?pageid=1" id="125"><i
									class="fa fa-ban"></i> Danh sách cấm</a></li>
						</ul></li>
					<li><a href="AdminQuanLiComment?pageid=1"><i
							class="fa fa-comments"> </i> quản lí Bình luận</a></li>
					<li><a href="AdminWebMeta"><i class="fa fa-info-circle">
						</i> Thông tin phiên bản</a></li>

				</ul>
			</div>
		</div>

		<!-- Kết thúc Menu bên trái trang web -->
		<div class="pagebody">
			<div class="page-body-container">
				<div class="page-body-header">
					<p>
						<i class="fa fa-dashboard" style="font-size: 20px"></i> Bảng Tin
					</p>
				</div>
				<div class="container">
					<div class="row">
						<div class="col-sm-4">
							<div class="tk-box">
								<div class="tk-box-logo">
									<i class="fa fa-user-plus"></i>
								</div>
								<div class="tk-box-content">

									<h2>${member_current_month}</h2>
									<p>NGƯỜI ĐĂNG KÍ MỚI THÁNG NÀY</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="tk-box">
								<div class="tk-box-logo"
									style="background-color: rgb(66, 125, 252);">
									<i class="fa fa-comments"></i>
								</div>
								<div class="tk-box-content"
									style="background-color: rgb(116, 158, 250);">

									<h2>${cmt_current_month}</h2>
									<p>LƯỢT BÌNH LUẬN THÁNG NÀY</p>
								</div>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="tk-box">
								<div class="tk-box-logo"
									style="background-color: rgb(175, 62, 250);">
									<i class="fa fa-graduation-cap"></i>
								</div>
								<div class="tk-box-content"
									style="background-color: rgb(196, 116, 250);">
									<h2>${test_current_month}</h2>
									<p>LƯỢT HOÀN THÀNH THI THỬ THÁNG NÀY</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="performance">
							<div class="member-test">
								<div class="content-test-header">
									<h5>Top 5 học viên thi thử nhiều nhất</h5>
									<h5 style="float: right;">Số lần thi thử</h5>
									<hr>
								</div>
								<c:forEach items="${listTopTesting}" varStatus="Member"
									var="list">
									<div class="content-test-member">
										<h7>${list.getHo_ten() }</h7>
										<h7 style="float: right;">${list.getTesting() }</h7>
										<hr>
									</div>
								</c:forEach>
							</div>
							<div class="member-test">
								<div class="content-test-header">
									<h5>Top 5 học viên bình luận nhiều nhất</h5>
									<h5 style="float: right;">Số lần bình luận</h5>
									<hr>
								</div>
								<c:forEach items="${listTopCmt}" varStatus="Member" var="list">
									<div class="content-test-member">
										<h7>${list.getHo_ten()}</h7>
										<h7 style="float: right;">${list.getCmt() }</h7>
										<hr>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>