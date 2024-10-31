<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Kết quả '${tukhoa }'</title>

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

</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->


	<div class="container-wrapper">
		<div class="header-link">
			<div class="container">
				<a href="Foward">Trang chủ</a> <a href="#" class="active">/ Kết quả từ khóa '${tukhoa }'</a>
			</div>
		</div>
		<div class="post-list">
			<div class="container">
				<div class="row">
					<div class="col-sm-10"
						style="border-right: 1px rgb(196, 196, 196) solid; margin-bottom: 30px">
						<c:forEach items="${listPost}" var="list" varStatus="Post">
							<div class="post">
								<a href="Noidungbaiviet?pageid=${list.getId()}">
									<div class="image-post">
										<div class="img-inner-post">
											<img src="ImgUpload/${list.getImage()}" alt="">
										</div>
									</div>
									<div class="content-post">
										<div class="title-post">
											<h5>${list.getTitle()}</h5>
										</div>
										<div class="time-post">
											<ul>
												<li><i class="fa fa-clock-o mr-5"></i>${list.getTime()}</li>
												<li><i class="fa fa-user-circle"></i>admin</li>
											</ul>
										</div>
										<div class="descreption">
											<p>${list.getDescribe()}</p>
										</div>
										<div class="read-more">
											<div class="btn">
												<button class="btn-readmore">
													ĐỌC TIẾP <i class="fa fa-toggle-right"></i>
												</button>
											</div>
										</div>
									</div>
								</a>
							</div>
						</c:forEach>
					</div>
					<div class="col-sm-2">
						<form action="SearchController" method="post"
							style="margin-top: 0">
							<div class="input-search">

								<input type="text" class="form-control" name="search"
									placeholder="Tìm kiếm...">
								<div class="input-search-btn">
									<button class="btn-search" type="submit" style="height: 36px">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</form>
						<div class="recent-post">
							<h5>Bài viết gần đây</h5>
							<c:forEach items="${listRePost}" var="list" varStatus="Post">
								<div class="mini-post">
									<ul class="mini-post-list">
										<li><a href="Noidungbaiviet?pageid=${list.getId()}">
												<div class="content-mini-post">
													<h6>${list.getTitle() }</h6>
													<p>
														<i class="fa fa-clock-o mr-5"></i>${list.getTime() }
													</p>
												</div>
										</a></li>
									</ul>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>



	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>
