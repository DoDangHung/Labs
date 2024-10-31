<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header-top">
            <div class="navbar-header">
                <div class="header-logo" style="padding: 10px;">
                    <!--LOGO-->
                    <a href="#" class="brand" style="color: #FFF; font-weight: 700; letter-spacing: 1px;">
                        <img id="img-logo" src="codes/img/logo-trang.png" alt="EDUMEGAVN.COM" style="margin-left: 0px; padding: 4px; ">
                        <span id="brand-span" style="display: inline;">EDUMEGAVN.COM</span>
                    </a>
                </div>
            </div>
            <div class="navbar-menu">
                <div class="admin-info">
                    <div class="dropdown">
                        <a href="#" data-toggle="dropdown"><i class="fa fa-user-circle"></i> admin <i class="fa fa-caret-down"></i></a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="AdminChangePassword"> <i class="fa fa-wrench"></i> Thay đổi mật khẩu</a>
                            <a class="dropdown-item" href="LogoutController"><i class="fa fa-sign-out"></i> Đăng xuất</a>
                        </div>
                        <a href="HomeController" style="margin-left: 30px">Xem trang  <i class="fa fa-external-link"></i> </a>
                    </div>
                </div>
                	
            </div>
        </div>
</body>
</html>