<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Người dùng bị cấm</title>

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
<script type="text/javascript">
function ban_user(i) {
	var r = confirm("Bạn có chắc chắn muốn cho phép người dùng này không?");
	if (r == true) {
		window.location = "AdminUserUnban?username="+i;
	}
}
</script>


</head>

<body style="background-color: rgb(231, 231, 231);">
	<div class="main-container">
		<jsp:include page="Header.jsp"></jsp:include>
<!-- Menu bên trái trang web -->
		<div class="left-sidebar">
			<div class="side-bar">
				<ul class="side-bar-menu">
					<li><a href="AdminFoward" ><i
							class="fa fa-dashboard" style="font-size: 20px"></i> Bảng Tin</a></li>
					<li><a href="#homeSubmenu" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-edit" style="font-size: 20px"></i> Bài Viết</a>
						<ul class="collapse list-unstyled" id="homeSubmenu">
							<li><a href="AdminQuanLiPostFoward?pageid=1#123" id="123"><i
									class="fa fa-th-list"></i> Tất cả bài viết</a></li>
							<li><a href="AdminPostController#124" id="124"><i class="fa fa-plus-circle"></i>
									Thêm bài viết</a></li>
						</ul></li>
					<li><a href="#homeSubmenu1" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle"><i
							class="fa fa-question-circle" style="font-size: 20px;"></i> Đề
							Thi</a>
						<ul class="collapse list-unstyled" id="homeSubmenu1">
							<li><a href="AdminQuanLiExam#125" id="125"><i
									class="fa fa-th-list"></i> Tất cả đề thi</a></li>
							<li><a href="AdminExamController#125" id="125"><i class="fa fa-plus-circle"></i>
									Thêm đề thi</a></li>
						</ul></li>
					<li><a href="#homeSubmenu2" data-toggle="collapse"
						aria-expanded="false" class="dropdown-toggle active-menu"><i
							class="fa fa-users" style="font-size: 20px;"></i> Người dùng</a>
						<ul class="collapse list-unstyled" id="homeSubmenu2">
							<li><a href="AdminUserManager?pageid=1" id="125"><i class="fa fa-th-list"></i>
									Tất cả người dùng</a></li>
							<li><a class="active-menu" href="AdminUserManager_ban?pageid=1" id="125"><i class="fa fa-ban"></i>
									Danh sách cấm</a></li>
						</ul></li>
					<li><a href="AdminQuanLiComment?pageid=1"><i class="fa fa-comments"> </i> quản lí
							Bình luận</a></li>
					<li><a href="AdminWebMeta"><i class="fa fa-info-circle"> </i> Thông
							tin phiên bản</a></li>

				</ul>
			</div>
		</div>
		
		<!-- Kết thúc Menu bên trái trang web -->
		<div class="pagebody">
			<div class="page-body-container">
				<div class="page-body-header">
					<p>
						<i class="fa fa-users" style="font-size: 20px"></i> Tất cả người dùng
					</p>
				</div>
				<div class="">
					<div class="success"
						style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messBan}</div>
						<div class="error"
						style="font-size: 16px; margin: 20px; font-weight: 600; text-align: center;">${messFailBan}</div>
					<table class="tb-mana-post">
						<thead>
							<tr>
								<th>Username</th>
								<th>Name</th>
								<th>Email</th>
								<th>Date Register</th>
								<th>Unban</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${listMem}" var="list" varStatus="Member">
								<tr>
									<td class="center">${list.getUsername()}</td>
									<td class="center">${list.getHo_ten()}</td>
									<td class="center">${list.getEmail()}</td>
									<td class="center">${list.getDate()}</td>
									<td class="center"><a class="red"
										onclick="ban_user('${list.getUsername()}')"
										style="cursor: pointer;"> <i class="fa fa-ban"
											style="font-size: 24px; color: green"></i></a></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination">
						<ul>
							<c:if test="${numberpage == 1 && numberpage == maxpageid}">
								<li class="page-item disabled"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage-1}">Trước</a></li>

								<li class="page-item disabled"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage+1}">Sau</a></li>
							</c:if>
							<c:if test="${numberpage == 1 && numberpage != maxpageid}">
								<li class="page-item disabled"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage+1}">Trước</a></li>

								<li class="page-item"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage+1}">Sau</a></li>
							</c:if>
							<c:if test="${numberpage == maxpageid && numberpage!=1}">
								<li class="page-item"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage-1}">Trước</a></li>

								<li class="page-item disabled"><a class="page-link"
									href="#">Sau</a></li>
							</c:if>

							<c:if test="${numberpage > 1 && numberpage < maxpageid}">
								<li class="page-item"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage-1}">Trước</a></li>

								<li class="page-item"><a class="page-link"
									href="AdminUserManager_ban?pageid=${numberpage+1}">Sau</a></li>
							</c:if>

						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>

</html>