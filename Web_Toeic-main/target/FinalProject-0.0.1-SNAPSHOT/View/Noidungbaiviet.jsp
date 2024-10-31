<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${post.getTitle() }</title>

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
    	  document.getElementById("btn-cmt").disabled=false;
      };
    </script>
    
    <script src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit" async defer>
    </script>
    
    
<script type="text/javascript">
    function Binhluan()
  	 {
    		var xhttp;
			var cmt_content = document.getElementById("comment").value;
			var member_id = "<%=session.getAttribute("sessionuserid")%>";
			var member_name = "<%=session.getAttribute("sessionuser")%>";
			var post_id = ${post.getId()};
			var url = "CommentController?cmt_content=" + cmt_content
				+ "&member_id=" + member_id + "&id_post=" + post_id
				+ "&member_name=" + member_name;
			document.getElementById("comment").value=null;
		if (window.XMLHttpRequest) {
			xhttp = new XMLHttpRequest();
		} else {
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xhttp.onreadystatechange = function() {
			if (xhttp.readyState == 4) {
				var data = xhttp.responseText;
				document.getElementById("thongbaocmt").innerHTML = "Bình luận đang chờ được duyệt";
			}

		}

		xhttp.open("POST", url, true);
		xhttp.send();
	}
</script>

</head>
<body>
	<!--HEADER ROW-->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- /HEADER ROW -->
	<div class="container-wrapper">
		<div class="header-link">
			<div class="container">
				<a href="Foward">Trang chủ</a> <a href="PostController?pageid=1">/ Bài viết</a> <a href="#"
					class="active">/ Bài viết số ${post.getId()}</a>
			</div>
		</div>
		<div class="read-post-container">
			<div class="container">
				<div class="row">
					<div class="col-sm-10"
						style="border-right: 1px rgb(230, 230, 230) solid;">

						<div class="read-post">
							<div class="image-post">
								<div class="img-inner-post">
									<img src="ImgUpload/${post.getImage()}" alt="">
								</div>
							</div>
							<div class="content-post">
								<div class="title-post">
									<h5>${post.getTitle()}</h5>
								</div>
								<div class="time-post">
									<ul>
										<li><i class="fa fa-clock-o mr-5"></i>${post.getTime()}</li>
										<li><i class="fa fa-user-circle"></i>admin</li>
									</ul>
								</div>
								<div class="content-read-post">
									<p style="text-indent: 50px;">
										<c:set var="kq"
											value="${fn:replace(post.getContent(),kitutrongdatabase1,kitutronghtml1)}" />
										<c:set var="kq"
											value="${fn:replace(kq,kitutrongdatabase2,kitutronghtml2)}" />
										<c:out value="${kq}" escapeXml="false" />
									</p>
								</div>

							</div>

						</div>

						<div class="comment">
							<%
								if (session.getAttribute("sessionuser") == null) {
							%>
							<div class="cmt-box">
								<h5>Bình luận bài viết</h5>
								<div class="form-group">
									<textarea class="form-control" rows="5" id="comment"
										disabled="disabled" placeholder="Đăng nhập để bình luận"></textarea>
								</div>
								<div class="btn-cmt">
									<button class="btn-readmore">ĐĂNG BÌNH LUẬN</button>
								</div>
							</div>
							<%
								} else {
							%>
							<div class="cmt-box">
								<h5>Bình luận bài viết</h5>
								<div class="success" id="thongbaocmt"></div>
								<div class="form-group">
									<textarea class="form-control" rows="5" id="comment"
										placeholder="Nhập bình luận..." pattern="[A-Za-z+ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]+$"></textarea>
								</div>
								<div class="btn-cmt">
									<div id="html_element" data-callback="correctCaptcha"></div>
									<button style="width: auto;" id="btn-cmt" class="btn-readmore" disabled="true" onclick="Binhluan()">ĐĂNG BÌNH LUẬN</button>
								</div>
							</div>
							<%
								}
							%>
							<div class="cmt-user-list">
								<c:forEach items="${listCmt}" var="list" varStatus="Comment">
									<div class="cmt-user">
										<div class="row">
											<div class="col-sm-2">
												<div class="image-cmt">
													<div class="img-inner-cmt">
														<img src="codes/img/user.png" alt="">
													</div>
												</div>
											</div>
											<div class="col-sm-10">

												<div class="cmt-content">
													<div class="name">
														<h4>${list.getMember_name()}</h4>
														<div class="time-post">
															<i class="fa fa-clock-o mr-5"></i>${list.getCmt_time()}
														</div>
														<p>${list.getCmt_content()}</p>
													</div>
												</div>

											</div>
										</div>
									</div>
								</c:forEach>
							</div>
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

	

	<div>
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>

</body>
</html>