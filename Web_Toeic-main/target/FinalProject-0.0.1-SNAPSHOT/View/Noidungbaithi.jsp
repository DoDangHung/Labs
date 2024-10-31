<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Làm bài thi số ${listExam[2].getExam_id()}</title>

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

<script>
	var timeLeft = 7200;
	var hour = 2;
	var min = 0;
	var sec = 0;
	var k;

	function start_exam() {
		document.getElementById("start-exam").style.display = "none";
		document.getElementById("main-exam").style.display = "block";
		document.getElementById("header-part").innerHTML = "Part I: Picture Description";
		document.getElementById("part-1").style.display = "block";
		document.getElementById("finish-all").style.display = "block";
		k = setInterval(countdown, 1);
	}

	$(function(){// chỉ 1 audio phát trong cùng 1 thời điểm
	    $("audio").on("play", function() {
	        $("audio").not(this).each(function(index, audio) {
	            audio.pause();
	        });
	    });
	});
	function next(i) {
		if (i == 1) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-1").style.display = "block";
			document.getElementById("part-2").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part I: Picture Description";
		} else if (i == 2) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-1").style.display = "none";
			document.getElementById("part-2").style.display = "block";
			document.getElementById("part-3").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part II: Question - Response";
		} else if (i == 3) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-2").style.display = "none";
			document.getElementById("part-3").style.display = "block";
			document.getElementById("part-4").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part III: Short Conversations";
		} else if (i == 4) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-3").style.display = "none";
			document.getElementById("part-4").style.display = "block";
			document.getElementById("part-5").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part IV: Short Talks";
		} else if (i == 5) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-4").style.display = "none";
			document.getElementById("part-5").style.display = "block";
			document.getElementById("part-6").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part V: Incomplete Sentences";
		} else if (i == 6) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-5").style.display = "none";
			document.getElementById("part-6").style.display = "block";
			document.getElementById("part-7").style.display = "none";
			document.getElementById("header-part").innerHTML = "Part VI: Text Completion";
		} else if (i == 7) {
			var sounds = document.getElementsByTagName('audio');
			  for(i=0; i<sounds.length; i++) sounds[i].pause();
			document.getElementById("part-6").style.display = "none";
			document.getElementById("part-7").style.display = "block";
			document.getElementById("header-part").innerHTML = "Part VII: Reading Comprehension";
		}

	}
	function countdown() {
		if (timeLeft == -1) {
			doSomething();
			clearInterval(k);

		} else {
			document.getElementById("countdown").innerHTML = hour + "h " + min
					+ "m " + sec + "s";
			hour = Math.floor(timeLeft / (60 * 60));
			min = Math.floor(timeLeft / 60) - hour * 60;
			sec = timeLeft - hour * 60 * 60 - min * 60;
			timeLeft--;
		}
	}

	function doSomething() {
		var r = confirm("Hết giờ làm bài. Vui lòng nộp bài");
		if (r == true) {
			document.getElementById("myForm").submit();
		} else {
			doSomething();
		}

	}
	function Finish() { // nộp bài
		var r = confirm("Bạn có chắc chắn nộp bài không?");
		if (r == true) {
			document.getElementById("myForm").submit();
		}
	}
	function exit() { // thoát ra ngoài
		var r = confirm("Bạn có chắc chắn thoát không?");
		if (r == true) {
			window.location = "ExamController?pageid=1";
		}
	}
	
	window.onbeforeunload = function() { //nếu thoát ra khỏi trang làm bài thi thì sẽ hỏi
		return "Bạn có chắc chắn thoát khỏi trang làm bài thi?";
	};
</script>

</head>

<body class="body-exam">
	<%
		if (session.getAttribute("sessionuser") != null || session.getAttribute("sessionadmin") != null) {
	%>
	<div id="load"
		class="introLoading introLoader gifLoader theme-dark bubble">
		<div id="introLoaderSpinner" class="gifLoaderInner" style=""></div>
	</div>
	<div id="contents">
	<div class="header-exam">
		<div class="logo-exam">
			<div class="image-exam">
				<img src="codes/img/logo.png">
				<div class="header-part" id="header-part"></div>
			</div>
		</div>
		<ul class="top-nav-exam">
			<li><a id="finish-all" href="#" onclick="Finish()"
				class="finish-exam" style="display: none"> <i
					class="fa fa-check-square-o"></i> Finish all
			</a></li>
			<li><a href="#"> <i class="	fa fa-clock-o"></i>
					<div id="countdown" class="countdown"></div>
			</a></li>
			<li><a href="#" onclick="exit()"> <i
					class="fa fa-times-circle-o"></i>
			</a></li>
		</ul>
	</div>
	<div class="container b-white">
		<div class="start-exam" id="start-exam">
			<div class="start-exam-intro">
				<div class="exam-id">
					<h4>Mã đề ${listExam[2].getExam_id()}</h4>
				</div>
				<div class="exam-intro">
					<h6>Thời gian làm bài: 120 phút</h6>
					<h6>Thí sinh hãy trung thực khi làm bài.</h6>
					<p style="color: red; font-style: italic;">Thí sinh không được
						refresh trang khi đang làm bài.</p>
				</div>
			</div>
			<div class="btn-start-exam">
				<button class="btn-readmore" onclick="start_exam()">START</button>
			</div>
		</div>
		<div class="main-exam" id="main-exam">
			<form action="FinishExam?examid=${listExam[2].getExam_id()}"
				method="POST" id="myForm">
				<!-- PART I -->
				<div class="part" id="part-1" style="display: none;">
					<div class="question-start">
						<h3>Part I: Picture Description</h3>
						<p>
							<b>Directions: </b>For each question, you will see a picture and
							you will hear four short statements. The statements will be
							spoken just one time. They will not be printed in your test book
							so you must listen carefully to understand what the speaker says.
							When you hear the four statements, look at the picture and choose
							the statement that best describes what you see in the picture.
							Choose the best answer A, B, C or D
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==1 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer" onclick="pause_all_audio()">
										<audio controls id="audio-part-1">
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestionnumber()}. Select the answer</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>A
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>B
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>C
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>D
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">

						<a class="btn-readmore" onclick="next(2)"
							style="cursor: pointer; color: #FFF;" href="#part-2">NEXT</a>
					</div>
				</div>
				<!-- PART II -->
				<div class="part" id="part-2" style="display: none;">
					<div class="question-start">
						<h3>Part II: Question - Response</h3>
						<p>
							<b>Directions: </b>In this part of the test, you will hear a
							question or statement spoken in English, followed by three
							responses, also spoken in English. The question or statement and
							the responses will be spoken just one time. They will not be
							printed in your test book, so you must listen carefully. You are
							to choose the best response to each question or statement. Now
							listen to a sample question.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==2}">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer" onclick="pause_all_audio()">
										<audio controls id="audio-part-2">
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage() }" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestionnumber()}. Select the answer</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>A
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>B
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>C
											</label></li>

										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(1)"
							style="cursor: pointer; color: #FFF;" href="#part-1">PREV</a> <a
							class="btn-readmore" onclick="next(3)"
							style="cursor: pointer; color: #FFF;" href="#part-3">NEXT</a>
					</div>
				</div>
				<!-- PART III -->
				<div class="part" id="part-3" style="display: none;">
					<div class="question-start">
						<h3>Part III: Short Conversations</h3>
						<p>
							<b>Directions: </b>You will hear some conversations between two
							people. You will be asked to answer three questions about what
							the speakers say in each conversation. Select the best response
							to each question and mark the letter (A), (B), (C) or (D) on your
							answer sheet. The conversations will not be printed in your test
							book and will be spoken only one time.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==3 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer" onclick="pause_all_audio()">
										<audio controls id="audio-part-${list.getQuestionnumber()}">
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestion()}</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>${list.getAnwser1()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>${list.getAnwser2()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>${list.getAnwser3()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>${list.getAnwser4()}
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(2)"
							style="cursor: pointer; color: #FFF;" href="#part-2">PREV</a> <a
							class="btn-readmore" onclick="next(4)"
							style="cursor: pointer; color: #FFF;" href="#part-4">NEXT</a>
					</div>
				</div>
				<!-- PART IV -->
				<div class="part" id="part-4" style="display: none;">
					<div class="question-start">
						<h3>Part IV: Short Talks</h3>
						<p>
							<b>Directions: </b>Directions: You will hear some talks given by
							a single speaker. You will be asked to answer three questions
							about what the speaker says in each talk. Select the best
							response to each question and mark the letter (A), (B), (C) or
							(D) on your answer sheet. The talks will not be printed in your
							test book and will be spoken only one time.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==4 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer" onclick="pause_all_audio()">
										<audio controls id="audio-part-${list.getQuestionnumber()}">
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestion()}</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>${list.getAnwser1()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>${list.getAnwser2()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>${list.getAnwser3()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>${list.getAnwser4()}
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(3)"
							style="cursor: pointer; color: #FFF;" href="#part-3">PREV</a> <a
							class="btn-readmore" onclick="next(5)"
							style="cursor: pointer; color: #FFF;" href="#part-5">NEXT</a>
					</div>
				</div>
				<!-- PART V -->
				<div class="part" id="part-5" style="display: none;">
					<div class="question-start">
						<h3>Part V: Incomplete Sentences</h3>
						<p>
							<b>Directions: </b>A word or pharse is missing in each of the
							sentences below. Four answer choices are given below each
							sentence. Select the best answer to complete the sentence. Then
							mark the letter (A), (B), (C) or (D) on your answer sheet.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==5 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer">
										<audio controls>
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestion()}</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>${list.getAnwser1()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>${list.getAnwser2()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>${list.getAnwser3()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>${list.getAnwser4()}
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(4)"
							style="cursor: pointer; color: #FFF;" href="#part-4">PREV</a> <a
							class="btn-readmore" onclick="next(6)"
							style="cursor: pointer; color: #FFF;" href="#part-6">NEXT</a>
					</div>
				</div>
				<!-- PART VI -->
				<div class="part" id="part-6" style="display: none;">
					<div class="question-start">
						<h3>Part VI: Text Completion</h3>
						<p>
							<b>Directions: </b>Read the texts that follow. A word or pharse
							is missing in some of the sentences. Four answer choices are
							given below each of the sentences. Select the best answer to
							complete the text. Then mark the letter (A), (B), (C) or (D) on
							your answer sheet.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==6 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer">
										<audio controls>
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestion()}</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>${list.getAnwser1()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>${list.getAnwser2()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>${list.getAnwser3()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>${list.getAnwser4()}
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(5)"
							style="cursor: pointer; color: #FFF;" href="#part-5">PREV</a> <a
							class="btn-readmore" onclick="next(7)"
							style="cursor: pointer; color: #FFF;" href="#part-7">NEXT</a>
					</div>
				</div>
				<!-- PART VII -->
				<div class="part" id="part-7" style="display: none;">
					<div class="question-start">
						<h3>Part VII: Reading Comprehension</h3>
						<p>
							<b>Directions: </b>In this part you will read a selection of
							texts, such as magezine and newspaper articles, letters, and
							advertisements. Each text is followed by several questions.
							Select the best answer for each question and mark the letter (A),
							(B), (C) or (D) on your answer sheet.
						</p>
						<hr>
					</div>
					<c:forEach items="${listExam}" var="list" varStatus="Exam">
						<c:if test="${list.getPart()==7 }">
							<div class="question">
								<c:if test="${list.getAudio()!=''}">
									<p class="audio-p">Audio:</p>
									<div class="audioplayer">
										<audio controls>
											<source src="FileUpload/${list.getAudio()}" type="audio/mp3">
										</audio>
									</div>
								</c:if>
								<c:if test="${list.getImage()!='' }">
									<div class="img-exam">
										<img src="FileUpload/${list.getImage()}" alt="">
									</div>
								</c:if>
								<div class="question-anwser">
									<div class="question-a">
										<p>${list.getQuestion()}</p>
									</div>
									<div class="anwser">
										<ul class="anwser-list">
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="a"
												id="${list.getQuestionnumber()}-a"> <label
												for="${list.getQuestionnumber()}-a"> <i
													class="icon icon_radio"></i>${list.getAnwser1()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="b"
												id="${list.getQuestionnumber()}-b"> <label
												for="${list.getQuestionnumber()}-b"> <i
													class="icon icon_radio"></i>${list.getAnwser2()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="c"
												id="${list.getQuestionnumber()}-c"> <label
												for="${list.getQuestionnumber()}-c"> <i
													class="icon icon_radio"></i>${list.getAnwser3()}
											</label></li>
											<li><input type="radio"
												name="${list.getQuestionnumber()}" value="d"
												id="${list.getQuestionnumber()}-d"> <label
												for="${list.getQuestionnumber()}-d"> <i
													class="icon icon_radio"></i>${list.getAnwser4()}
											</label></li>
										</ul>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>

					<div class="btn-next">
						<a class="btn-readmore" onclick="next(6)"
							style="cursor: pointer; color: #FFF;" href="#part-6">PREV</a> <a
							class="btn-readmore" onclick="Finish()"
							style="cursor: pointer; color: #FFF;">FINISH</a>
					</div>
				</div>
			</form>
		</div>
		</div>
	</div>
	<%
		} else {
	%>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1
		style="margin-top: 90px; text-align: center; margin-bottom: 400px; justify-content: middle;">Vui
		Lòng Đăng Nhập Để Thi Thử</h1>
	<jsp:include page="Footer.jsp"></jsp:include>
	<%
		}
	%>

</body>

</html>