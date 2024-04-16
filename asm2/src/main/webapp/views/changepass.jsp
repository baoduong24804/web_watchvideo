<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-sm-4 border p-5">
            <h2 class="text-center mb-4">Đổi mật khẩu</h2>
            <form action="/asm2/views/Account/doi-mat-khau" method="post">
                <div class="mb-3">
                                    <p class="text-danger fw-bold"><c:if test="${ not empty mes1 }">${mes1}</c:if></p>
                    	<p class="text-primary fw-bold"><c:if test="${ not empty mes2 }">${mes2}</c:if></p>
                    	
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="Nhập địa chỉ email" autofocus required name="email_input">
                </div>
                <div class="mb-3">
                    <label for="inputPassword" class="form-label">Mật khẩu cũ</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Nhập mật khẩu" required name="pass_input_cu">
                </div>
                <div class="mb-3">
                 <p class="text-danger fw-bold"><c:if test="${ not empty mes }">${mes}</c:if></p>
                    <label for="confirmPassword" class="form-label">Mật khẩu mới</label>
                    <input type="password" id="confirmPassword" class="form-control" placeholder="Nhập lại mật khẩu" required name="pass_input1">
                </div>
                <div class="mb-3">
                 
                    <label for="confirmPassword" class="form-label">Xác nhận mật khẩu mới</label>
                    <input type="password" id="confirmPassword" class="form-control" placeholder="Nhập lại mật khẩu" required name="pass_input2">
                </div>
                <div class="d-grid">
                    <button class="btn btn-primary btn-block" type="submit" name="btn-dang-ky" value="1">Đổi mật khẩu</button>
                </div>
            </form>
            <div class="text-center mt-3">
                <span>Quay lại trang</span>
                <a href="/asm2/views/Account?action=dang-nhap">Đăng nhập</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>