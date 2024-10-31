<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<%
		if (session.getAttribute("sessionuser") == null && session.getAttribute("sessionadmin") == null) {
	%>
	<div class="header" id="header-top">
        <div class="row" style="margin:0px">
            <div class="container">
                <div class="col-sm-4">
                    <div class="header-logo">
                        <!--LOGO-->
                        <a href="#" class="brand">
                            <img id="img-logo" src="codes/img/logo.png" alt="EDUMEGAVN.COM" />
                            <span id="brand-span">EDUMEGAVN.COM</span>
                        </a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="navbar">
                        <!--MENU-->
                        <div class="menu">
                            <ul class="nav">
                                <li><a href="HomeController">Trang chủ</a></li>
                                <li><a href="PostController?pageid=1">Bài viết</a></li>
                                <li><a href="ExamController?pageid=1">Thi thử</a></li>
                                <li><a href="Login">Đăng nhập</a></li>
                                <li><a href="RegisterFoward">Đăng kí</a></li>
                                
                            </ul>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
	<%
		} else if (session.getAttribute("sessionuser") != null) { 
	%>
	<div class="header" id="header-top">
        <div class="row" style="margin:0px">
            <div class="container">
                <div class="col-sm-4">
                    <div class="header-logo">
                        <!--LOGO-->
                        <a href="#" class="brand">
                            <img id="img-logo" src="codes/img/logo.png" alt="EDUMEGAVN.COM" />
                            <span id="brand-span">EDUMEGAVN.COM</span>
                        </a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="navbar">
                        <!--MENU-->
                        <div class="menu">
                            <ul class="nav">
                                <li><a href="HomeController">Trang chủ</a></li>
                                <li><a href="PostController?pageid=1">Bài viết</a></li>
                                <li><a href="ExamController?pageid=1">Thi thử</a></li>
                                <li>
                                    <div class="dropdown">
                                        <a href="#" data-toggle="dropdown"><%=session.getAttribute("sessionuser")%> <i class="fa fa-caret-down"></i></a>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="Profile"><i class="fa fa-user-circle"></i> Thông tin cá nhân</a>
                                            <a class="dropdown-item" href="LogoutController"><i class="fa fa-sign-out"></i> Thoát</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%
		} else if (session.getAttribute("sessionadmin") != null) { 
	%>
	<div class="header" id="header-top">
        <div class="row" style="margin:0px">
            <div class="container">
                <div class="col-sm-4">
                    <div class="header-logo">
                        <!--LOGO-->
                        <a href="#" class="brand">
                            <img id="img-logo" src="codes/img/logo.png" alt="EDUMEGAVN.COM" />
                            <span id="brand-span">EDUMEGAVN.COM</span>
                        </a>
                    </div>
                </div>
                <div class="col-sm-8">
                    <div class="navbar">
                        <!--MENU-->
                        <div class="menu">
                            <ul class="nav">
                                <li><a href="HomeController">Trang chủ</a></li>
                                <li><a href="PostController?pageid=1">Bài viết</a></li>
                                <li><a href="ExamController?pageid=1">Thi thử</a></li>
                                <li><a href="AdminFoward"><i class="fa fa-gears"></i> Trang quản trị</a></li>
                                <li>
                                    <div class="dropdown">
                                        <a href="#" data-toggle="dropdown"><%=session.getAttribute("sessionadmin")%> <i class="fa fa-caret-down"></i></a>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="LogoutController"><i class="fa fa-sign-out"></i> Đăng xuất</a>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
	
	<%
		}
	%>
</body>
</html>