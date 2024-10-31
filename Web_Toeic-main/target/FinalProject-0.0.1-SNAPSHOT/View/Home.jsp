<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    


    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

    <link href="codes/css/style.css" rel="stylesheet" />
    <script src="codes/js/main.js"></script>

</head>

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


<body>
<div id="load"
		class="introLoading introLoader gifLoader theme-dark bubble">
		<div id="introLoaderSpinner" class="gifLoaderInner" style=""></div>
	</div>
<div id="contents">
    <jsp:include page="Header.jsp"></jsp:include>
    <!--slider bootstrap-->
    <div id="section-1" class="carousel slide" data-ride="carousel">

        <!-- Indicators -->
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>

        <!-- The slideshow -->
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="codes/img/slider1.jpg" alt="New York" width="100%" height="100%">
            </div>
            <div class="carousel-item">
                <img src="codes/img/slider2.jpg" alt="New York" width="100%" height="100%">
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="carousel-control-prev" href="#section-1" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#section-1" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
    <div class="section-2">
        <div class="container">
            <div class="row" style="margin:0;">
                <div class="select-title">
                    <h2>TẠI SAO NÊN CHỌN EDUMEGAVN</h2>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <div class="icon-featured text-center">
                        <h4>Cập nhật đề thi TOEIC mới mỗi tháng</h4>
                        <img src="https://toeic24.vn/img/1.png" class="featured-icon" />
                        <p>Các bộ đề TOEIC quốc tế, ETS... luôn được cập nhật liên tục và thường xuyên.</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="icon-featured text-center">
                        <h4>Nâng cao kĩ năng làm bài thi TOEIC</h4>
                        <img src="https://toeic24.vn/img/2.png" class="featured-icon" />
                        <p>Rèn luyện 2 kỹ năng TOEIC Reading và TOEIC Listening nhanh nhất.</p>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="icon-featured text-center">
                        <h4>Đề thi TOEIC có đáp án và giải thích</h4>
                        <img src="https://toeic24.vn/img/3.png" class="featured-icon" />
                        <p>Sau khi làm bài bạn có thể kiểm tra đáp án, giải thích chi tiết từng đáp án.</p>
                    </div>
                </div>
            </div>
            <div class="row test">
                <a href="ExamController?pageid=1" class="btn btn-primary mt-15 btn-test">THI THỬ NGAY</a>
            </div>
        </div>
    </div>
    <div class="section-3">
        <div class="container">
            <div class="row" style="margin:0;">
                <div class="select-title select-title-1">
                    <h2>Đánh giá của người dùng</h2>
                </div>
                <div class="select-title-1">
                    <h4>Mọi ý kiến đóng góp của bạn sẽ làm website được hoàn thiện hơn.</h4>
                </div>
            </div>
            <div class="fb-user">
                <div class="row">
                    <div class="col-sm-4">
                        <div class="feedback">
                            <div class="fb-header">
                                <div class="image">
                                    <div class="img-inner">
                                        <img src="https://toeic24.vn/img/user1.jpg" alt="">
                                    </div>
                                </div>
                                <div class="name">
                                    <h5>Vũ Trọng Phụng</h5>
                                    <span>Sinh viên PTIT</span>
                                </div>
                            </div>
                            <div class="content">
                                <p>Website thi thử TOEIC có tâm nhất mình từng thấy, hoàn toàn miễn phí dễ dàng sử dụng, đề thi sát thực tế, cập nhật thường xuyên.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="feedback">
                            <div class="fb-header">
                                <div class="image">
                                    <div class="img-inner">
                                        <img src="https://toeic24.vn/img/user2.jpg" alt="">
                                    </div>
                                </div>
                                <div class="name">
                                    <h5>Đỗ Phương</h5>
                                    <span>Sinh viên kế toán</span>
                                </div>
                            </div>
                            <div class="content">
                                <p>Website rất tốt, tôi thường xuyên giới thiệu cho học viên làm thử để cải thiện trình độ TOEIC. Cảm ơn EDUMEGAVN rất nhiều.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="feedback">
                            <div class="fb-header">
                                <div class="image">
                                    <div class="img-inner">
                                        <img src="https://toeic24.vn/img/user3.jpg" alt="">
                                    </div>
                                </div>
                                <div class="name">
                                    <h5>Nguyễn Duyên</h5>
                                    <span>Nhân viên kinh doanh</span>
                                </div>
                            </div>
                            <div class="content">
                                <p>Website EDUMEGAVN rất tiện lợi, có thể luyện đề thi TOEIC mọi lúc mọi nơi, có chấm điểm và lời giải chi tiết sau khi làm xong đề.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="Footer.jsp"></jsp:include>
    </div>
</body>

</html>