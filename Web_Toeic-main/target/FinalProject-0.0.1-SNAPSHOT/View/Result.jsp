<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kết quả bài thi số ${listExam[2].getExam_id()}</title>

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
            </div>
            <div class="record-score">
                <table class="tb-score">
                    <thead>
                        <tr>
                            <th>Phần</th>
                            <th>Số câu làm đúng</th>
                            <th>Tổng điểm</th>
                            <th>Đáp án</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Nghe</td>
                            <td>${scores_listenning}</td>
                            <td>${scores_listenning*5}</td>
                            <td rowspan="2"><a href="#" onclick="showResult()" style="text-decoration: none;">Hiện</a></td>
                        </tr>
                        <tr>
                            <td>Đọc</td>
                            <td>${scores_reading}</td>
                            <td>${scores_reading*5}</td>

                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="record-result" style="display: none" id="record-result">
                <table class="tb-score">
                    <thead>
                        <tr>
                            <th>Câu</th>
                            <th>Đáp án của bạn</th>
                            <th>Đáp án đúng</th>
                            <th>Kết quả</th>
                        </tr>
                    </thead>
                    <c:forEach begin="0" end="199" step="1" var="i">
                    <tbody>
                        <tr>
                            <td>${listExam[i].getQuestionnumber()}</td>
                            <td>${listAnw[i].getCorrect_anwser()}</td>
                            <td>${listExam[i].getCorrect_anwser()}</td>
                            <td>
                            <c:if test="${listExam[i].getCorrect_anwser().equals(listAnw[i].getCorrect_anwser())}">
                            	<div class="success">
                            		<i class="fa fa-check" style="font-size: 32px"></i>
                            	</div>
                            </c:if>
                            <c:if test="${!listExam[i].getCorrect_anwser().equals(listAnw[i].getCorrect_anwser())}">
                            	<div class="error">
                            		<i class="fa fa-remove" style="font-size: 32px"></i>
                            	</div>
                            </c:if>
                            
                            </td>
                        </tr>

                    </tbody>
                    </c:forEach>
                </table>
            </div>


            <div class="btn-start-exam">
            	<a href="SaveResult?exam_id=${exam_id}&result_score=${scores_reading*5+scores_listenning*5}" class="btn-readmore">SAVE</a>
                <a href="ExamController?pageid=1" class="btn-readmore">EXIT</a>
            </div>
        </div>
    </div>


</body>

</html>