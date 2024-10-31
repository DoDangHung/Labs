<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
    <script type="text/javascript">
    	function showResult(){
    		document.getElementById("record-result").style.display = "block";
    	}
    </script>


</head>

<body class="body-exam">
    <div class="header-exam">
        <div class="logo-exam">
            <div class="image-exam">
                <img src="codes/img/logo.png">
                <div class="header-part" id="header-part">Result EXAM
                </div>
            </div>
        </div>
        <ul class="top-nav-exam">
            <li>
                <a href="Foward" class="finish-exam">
                    <i class="fa fa-home"></i> Trang chủ
                </a>
            </li>
            <li>
                <a href="#">
                    <i class="	fa fa-clock-o"></i>
                    <div id="countdown" class="countdown">0h 00m 00s</div>
                </a>
            </li>
            <li>
                <a href="Foward">
                    <i class="fa fa-times-circle-o"></i>
                </a>
            </li>
        </ul>
    </div>
    <div class="container b-white">
        <div class="result-exam" id="result-exam">
            <div class="exam-id">
                <h4>Mã đề ${exam_id }</h4>
            </div>
            <div class="result-tks">
                <p>Cám ơn bạn đã ủng hộ team EDUMEGAVN.</p>
            </div>
            <div class="result-tks">
                <p class="success" style="font-size: 16px">${messSave }</p>

            <div class="btn-start-exam">
                <a href="ExamController?pageid=1" class="btn-readmore">EXIT</a>
            </div>
        </div>
    </div>


</body>

</html>