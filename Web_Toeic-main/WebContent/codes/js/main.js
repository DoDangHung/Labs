//Scrolling Logo
window.onscroll = function() { scrollFunction() };

function scrollFunction() {
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        document.getElementById("img-logo").style.marginLeft = "50px";
        document.getElementById("brand-span").style.display = "none";
        document.getElementById("header-top").style.padding = "5px";
    } else {
        document.getElementById("img-logo").style.marginLeft = "0px";
        document.getElementById("brand-span").style.display = "inline";
        document.getElementById("header-top").style.padding = "15px";
    }
}

//logi validation

function checkUser() {

    var user = document.getElementById("user").value;
    if (user == "") {
        document.getElementById("errorUser").innerHTML = "Chưa nhập Tên đăng nhập";
    } else {
        document.getElementById("errorUser").innerHTML = null;
    }
}

function checkPass() {
    var user = document.getElementById("pass").value;
    if (user == "") {
        document.getElementById("errorPass").innerHTML = "Chưa nhập Mật khẩu";
    } else {
        document.getElementById("errorPass").innerHTML = null;
    }
}

function checkLogin() {
    var user = document.getElementById("user").value;
    var pass = document.getElementById("pass").value;

    if (user == "" || pass == "") {
        if (user == "") {
            document.getElementById("errorUser").innerHTML = "Chưa nhập Tên đăng nhập";
        }
        if (pass == "") {
            document.getElementById("errorPass").innerHTML = "Chưa nhập Nhập mật khẩu";
        }
        return false;
    }
    return true;


}

//Register Validation

function checknameReg() { // Kiểm tra đã nhập tên chưa.
    var name = document.getElementById("name").value;
    if (name == "") {
        document.getElementById("errorName").innerHTML = "Chưa nhập Họ tên";
        return false;
    } else {
        document.getElementById("errorName").innerHTML = null;
        if (name.length > 45) {
            document.getElementById("errorName").innerHTML = "Tên quá dài";
            return false;
        } else
            return true;
    }
}

function checkuserReg() { // Kiểm tra đã nhập tên người dùng chưa.
	var userRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,20}$/;
    var user = document.getElementById("username_reg").value;
    if (user == "") {
        document.getElementById("errorUser_reg").innerHTML = "Chưa nhập Tên đăng nhập";
        return false;
    } else {
        document.getElementById("errorUser_reg").innerHTML = null;
        if (user.length > 20) {
            document.getElementById("errorUser_reg").innerHTML = "Tên đăng nhập quá dài";
            return false;
        } else
            return true;
    }
}

function checkpassReg() { //Kiểm tra pass đủ điều kiện từ 6 -20 kí tự và có chữ hoa chữ thường
    var pass = document.myForm.memberpass_reg.value;
    var paswd = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,20}$/;
    if (!pass.match(paswd) || pass == "") {
        document.getElementById("errorPass_reg").innerHTML = "Mật khẩu phải có chữ hoa(a-z), chữ thường(A-Z) và số(0-9)";
        return false;

    } else {
        document.getElementById("errorPass_reg").innerHTML = null;
        return true;
    }
}

function checkpass1Reg() { // check pass nhập lại có giống pass đã nhập không
    var pass = document.myForm.memberpass_reg.value;
    var pass1 = document.myForm.memberpass1_reg.value;

    if (pass1 != pass || pass1 == "") {
        document.getElementById("errorPass1_reg").innerHTML = "Mật khẩu không khớp";
        return false;
    } else {
        document.getElementById("errorPass1_reg").innerHTML = null;
        return true;
    }
}

function checkemailReg() { // Kiểm tra email đúng chuẩn chưa
    var email = document.myForm.memberemail.value;
    var emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (!emailformat.test(email) || email == "") {
        document.getElementById("errorEmail").innerHTML = "Email không hợp lệ";
        return false;

    } else {
        document.getElementById("errorEmail").innerHTML = null;
        return true;
    }
}

function checkbuttonReg() {
    var pass = document.myForm.memberuser_reg.value;
    var email = document.myForm.memberemail.value;
    var user = document.getElementById("username_reg").value;
    var name = document.getElementById("name").value;
    var pass = document.myForm.memberpass_reg.value;
    var pass1 = document.myForm.memberpass1_reg.value;

    if (checkuserReg() && checknameReg() && checkemailReg() && checkpassReg() &&
        checkpass1Reg()) {
        return true;
    } else {
        if (name == "") {
            document.getElementById("errorName").innerHTML = "Chưa nhập Họ tên";
        }
        if (user == "") {
            document.getElementById("errorUser_reg").innerHTML = "Chưa nhập Tên đăng nhập";
        }
        if (email == "") {
            document.getElementById("errorEmail").innerHTML = "Chưa nhập Email";
        }
        if (pass == "") {
            document.getElementById("errorPass_reg").innerHTML = "Chưa nhập Mật khẩu";
        }
        if (pass1 == "") {
            document.getElementById("errorPass1_reg").innerHTML = "Chưa nhập Mật khẩu";
        }
        return false;
    }

    return false;
}

function checkPass_change() { // Kiểm tra pass đủ điều kiện từ 6 -20 kí tự và có chữ hoa chữ thường
    var pass = document.myForm2.passnew.value;
    var passold = document.myForm2.passold.value;
    var paswd = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{6,20}$/;
    if (!pass.match(paswd) || pass == "") {
        document.getElementById("errorPass").innerHTML = "Mật khẩu phải có chữ hoa(a-z), chữ thường(A-Z) và số(0-9)";
        return false;

    } else {
        if (pass == passold) {
            document.getElementById("errorPass").innerHTML = "Mật khẩu mới không được trùng mật khẩu cũ";
            return false;
        }
        document.getElementById("errorPass").innerHTML = null;
        return true;
    }

}

function checkPass1_change() { // check pass nhập lại có giống pass đã nhập không
    var pass = document.myForm2.passnew.value;
    var pass1 = document.myForm2.passnew1.value;

    if (pass1 != pass || pass1 == "") {
        document.getElementById("errorPass1").innerHTML = "Mật khẩu không khớp";
        return false;
    } else {
        document.getElementById("errorPass1").innerHTML = null;
        return true;
    }
}

function checkbutton_change() {


    if (checkPass_change() && checkPass1_change()) {
        return true;
    }

    return false;
}


function change_favicon(img) { //set favicon
    var favicon = document.querySelector('link[rel="shortcut icon"]');
    
    if (!favicon) {
        favicon = document.createElement('link');
        favicon.setAttribute('rel', 'shortcut icon');
        var head = document.querySelector('head');
        head.appendChild(favicon);
    }
    
    
    favicon.setAttribute('type', 'image/png');
    favicon.setAttribute('href', img);
}

change_favicon('./codes/img/favicon.png');