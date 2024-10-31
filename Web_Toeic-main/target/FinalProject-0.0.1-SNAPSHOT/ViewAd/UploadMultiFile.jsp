<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Thêm đề thi</title>

<!-- Mark Down -->


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
<script>
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on(
			"change",
			function() {
				var fileName = $(this).val().split("\\").pop();
				$(this).siblings(".custom-file-label").addClass("selected")
						.html(fileName);
			});
</script>

</head>

<body style="background-color: rgb(231, 231, 231);">
	<div class="main-container">
		<div class="header-top">
			<div class="navbar-header">
				<div class="header-logo" style="padding: 10px;">
					<!--LOGO-->
					<a href="#" class="brand"
						style="color: #FFF; font-weight: 700; letter-spacing: 1px;"> <img
						id="img-logo" src="codes/img/logo-trang.png" alt="EDUMEGAVN.COM"
						style="margin-left: 0px; padding: 4px;"> <span
						id="brand-span" style="display: inline;">EDUMEGAVN.COM</span>
					</a>
				</div>
			</div>
			<div class="navbar-menu">
				<div class="admin-info">
					<div class="dropdown">
						<a href="#" data-toggle="dropdown"><i
							class="fa fa-user-circle"></i> admin <i class="fa fa-caret-down"></i></a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="#"> <i class="fa fa-wrench"></i>
								Thay đổi mật khẩu
							</a> <a class="dropdown-item" href="#"><i class="fa fa-sign-out"></i>
								Đăng xuất</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="left-sidebar">
			<div class="side-bar">
				<ul class="side-bar-menu">
					<li><a href="AdminFoward"><i class="fa fa-dashboard"
							style="font-size: 20px"></i> Bảng Tin</a></li>
					<li><a href="#homeSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-edit" style="font-size: 20px"></i> Bài Viết</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="AdminQuanLiPostFoward?pageid=1#123" id="123"><i
									class="fa fa-th-list"></i> Tất cả bài viết</a></li>
							<li><a href="#124" id="124" class="active-menu"><i
									class="fa fa-plus-circle"></i> Thêm bài viết</a></li>
						</ul></li>
					<li><a href="#homeSubmenu1" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle active-menu"><i
							class="fa fa-question-circle" style="font-size: 20px;"></i> Đề
							Thi</a>
						<ul class="collapse list-unstyled" id="homeSubmenu1">
							<li><a href="#125" id="125"><i class="fa fa-th-list"></i>
									Tất cả đề thi</a></li>
							<li><a href="#125" id="125" class="active-menu"><i class="fa fa-plus-circle"></i>
									Thêm đề thi</a></li>
						</ul></li>
					<li><a href="#"><i class="fa fa-users"></i> Người dùng</a></li>
					<li><a href="#"><i class="fa fa-comments"> </i> quản lí
							Bình luận</a></li>
					<li><a href="#"><i class="fa fa-info-circle"> </i> Thông
							tin phiên bản</a></li>

				</ul>
			</div>
		</div>
		<div class="pagebody">
			<div class="page-body-container">
				<div class="page-body-header">
					<p>
						<i class="fa fa-plus-circle" style="font-size: 20px"></i> Thêm đề thi
					</p>
				</div>
				<div class="row">
					<div class="container">
						<div class="col-sm-8">
							<h5>Thêm hình ảnh và file Excel câu hỏi cho bài thi:</h5>
							<form action="AdminUploadMultiFile?id=${id}" method="post" enctype="multipart/form-data">
								<div class="custom-file">
									<input type="file" name="image" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,image/*,.xls,audio/*" class="form-control"
										style="height: 100px" multiple="multiple">
								</div>
								<input type="submit" value="Đăng đề thi" class="btn-readmore"
									style="margin-top: 100px" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>