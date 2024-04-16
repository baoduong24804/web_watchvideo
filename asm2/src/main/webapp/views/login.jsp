<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <div class="container">
			
        <div class="row justify-content-center mt-5">
			<div class="col-sm-12 text-center mb-5">
			<a href="/asm2/views/index" class="btn btn-primary">Trang chủ</a>
			</div>
            <div class="col-sm-4 border p-5">
                <h2 class="text-center mb-4">Đăng nhập</h2>
                <form action="/asm2/views/Account/dang-nhap" method="post">
                    <div class="mb-3">
                    <p class="text-danger fw-bold"><c:if test="${ not empty mes }">${mes}</c:if></p>
                    	<p class="text-primary fw-bold"><c:if test="${ not empty mes2 }">${mes2}</c:if></p>
                        <label for="inputEmail" class="form-label">Tài khoản</label>
                        <input type="email" id="inputEmail" class="form-control" name="email_input" placeholder="Nhập địa chỉ email"
                            required autofocus>
                    </div>
                    <div class="mb-3">
                        <label for="inputPassword" class="form-label">Mật khẩu</label>
                        <div class="input-group">
                            <input type="password" id="inputPassword" class="form-control" name="pass_input" placeholder="Nhập mật khẩu"
                                required>
                        </div>
                    </div>
                    <div class="mb-3">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="rememberCheck" name="remember" value=1>
                            <label class="form-check-label" for="rememberCheck">Ghi nhớ</label>
                        </div>
                    </div>
                    <div class="d-grid">
                        <button class="btn btn-primary btn-block" type="submit">Đăng nhập</button>
                    </div>
                    <div class="text-center mt-3">
                        <a href="/asm2/views/Account?action=quen-mat-khau">Quên mật khẩu?</a> |
                        <a href="/asm2/views/Account?action=doi-mat-khau">Đổi mật khẩu</a>
                    </div>
                </form>
                <div class="text-center mt-3">
                    <span>Bạn chưa có tài khoản?</span>
                    <a href="/asm2/views/Account?action=dang-ky">Đăng ký</a>
                </div>
                
            </div>
        </div>
    </div>



</body>
</html>