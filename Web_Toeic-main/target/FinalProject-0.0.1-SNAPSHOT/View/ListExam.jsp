<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bài thi</title>

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
				<a href="#">Trang chủ</a> <a href="#" class="active">/ Đề thi</a>
			</div>
		</div>
		<div class="post-list">
			<div class="container">
				<div class="row">
					<div class="col-sm-10"
						style="border-right: 1px rgb(196, 196, 196) solid;">
						<div class="intro">
							<div class="select-title">
								<h2>ONLINE TOEIC TEST - Thi Thử TOEIC Online Miễn Phí</h2>
							</div>
							<div class="descreption-toeic">
								<p>
									<strong>TOEIC</strong> (viết tắt của <strong>Test of
										English for International Communication</strong> – Bài kiểm tra tiếng
									Anh giao tiếp quốc tế) là một chứng chỉ được sử dụng phổ biến
									nhằm đánh giá trình độ sử dụng tiếng Anh trong môi trường giao
									tiếp quốc tế. Ở Việt Nam những năm gần đây, chứng chỉ TOEIC nổi
									lên như một tiêu chuẩn phổ biến để đánh giá trình độ thông thạo
									tiếng Anh của người lao động được nhiều doanh nghiệp, tổ chức
									lựa chọn. Ngoài ra TOEIC còn là chuẩn đầu ra tiếng Anh của
									nhiều trường đại học cho sinh viên khi tốt nghiệp
								</p>
								<p>
									Để thuận tiện cho các bạn ôn luyện và thi lấy chứng chỉ TOEIC,
									<strong>EDUMEGAVN</strong> cung cấp các bài thi thử TOEIC
									online miễn phí. Với các đề thi TOEIC được biên soạn bài bản
									tương tự các đề thi thực tế giúp mọi người dễ dàng làm quen và
									đánh giá trình độ hiện tại. Từ đó có kế hoạch luyện thi TOEIC
									phù hợp
								</p>
								<p>Đề thi thử TOEIC được thực hiện theo format mới, có chấm
									điểm và giải thích chi tiết giúp bạn đánh giá chính xác điểm
									TOEIC hiện tại đặc biệt website dễ sử dụng và hoàn toàn miễn
									phí phù hợp với tất cả mọi người</p>
							</div>
						</div>
						<div class="list-exam">
							<div class="row">
								<div class="col-sm-11">
									<c:forEach items="${listExam}" var="list" varStatus="Post">
										<div class="exam-one">
											<a href="Noidungbaithi?examid=${list.getId()}">
												<div class="row">
													<div class="col-sm-4">
														<div class="exam-id">
															<div class="avt-circle">
																<span>MÃ ĐỀ</span>
																<div class="id">
																	<span>${list.getId()}</span>
																</div>

															</div>
														</div>
													</div>
													<div class="col-sm-8">
														<div class="descreption-exam">
															<div class="exam-time">
																<h4>Thời gian: 02h</h4>
															</div>
															<div class="read-listen">
																<p>Bài thi gồm 2 phần Reading & Listening, tổng cộng
																	có 200 câu làm trong 2h.</p>
															</div>
															<div class="btn-exam">
																<button class="btn-readmore">
																	THI THỬ <i class="fa fa-toggle-right"></i>
																</button>
															</div>
														</div>
													</div>
												</div>
											</a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="pagination">
							<ul>
							<c:if test="${numberpage == 1 && numberpage == maxpageid}">
								<li class="page-item disabled"><a class="page-link"
									href="">Trước</a></li>

								<li class="page-item disabled"><a class="page-link"
									href="">Sau</a></li>
							</c:if>	
								<c:if test="${numberpage == 1 && numberpage != maxpageid}">
									<li class="page-item disabled"><a class="page-link"
										href="ExamController?pageid=${numberpage+1}">Trước</a></li>

									<li class="page-item"><a class="page-link"
										href="ExamController?pageid=${numberpage+1}">Sau</a></li>
								</c:if>
								<c:if test="${numberpage == maxpageid && numberpage!=1}">
									<li class="page-item"><a class="page-link"
										href="ExamController?pageid=${numberpage-1}">Trước</a></li>

									<li class="page-item disabled"><a class="page-link" href="#">Sau</a></li>
								</c:if>

								<c:if test="${numberpage > 1 && numberpage < maxpageid}">
									<li class="page-item"><a class="page-link"
										href="ExamController?pageid=${numberpage-1}">Trước</a></li>

									<li class="page-item disabled"><a class="page-link"
										href="ExamController?pageid=${numberpage+1}">Sau</a></li>
								</c:if>
							</ul>
						</div>


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