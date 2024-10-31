<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>

    <!-- Font awesome -->

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

<body style="background-color: rgb(231, 231, 231);">
<div class="left-sidebar">
            <div class="side-bar">
                <ul class="side-bar-menu">
                    <li>
                        <a href="#" class="active-menu"><i class="fa fa-dashboard" style="font-size:20px"></i> Bảng Tin</a>
                    </li>
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-edit" style="font-size:20px"></i> Bài Viết</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="#123" id="123"><i class="fa fa-th-list"></i> Tất cả bài viết</a>
                            </li>
                            <li>
                                <a href="#124" id="124"><i class="fa fa-plus-circle"></i> Thêm bài viết</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#homeSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i class="fa fa-question-circle" style="font-size: 20px;"></i> Đề Thi</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu1">
                            <li>
                                <a href="#125" id="125"><i class="fa fa-th-list"></i> Tất cả đề thi</a>
                            </li>
                            <li>
                                <a href="#125" id="125"><i class="fa fa-plus-circle"></i> Thêm đề thi</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-users"></i> Người dùng</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-comments"> </i> quản lí Bình luận</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-info-circle"> </i> Thông tin phiên bản</a>
                    </li>

                </ul>
            </div>
        </div>
        
        </body>

</html>