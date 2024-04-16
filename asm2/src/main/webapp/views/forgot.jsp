<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quên mật khẩu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-sm-4">
            <h2 class="text-center mb-4">Quên mật khẩu</h2>
            <form action="/asm2/views/Account/quen-mat-khau" method="post">
                <div class="mb-3">
                    <label for="inputEmail" class="form-label">Email</label>
                     <div class="d-flex">
                        <input value="${ email}" type="text" id="inputCode" class="form-control w-75 me-2" placeholder="Nhập địa chỉ Email" required name="email_input">
                        <button  class="btn btn-outline-secondary w-25"  type="submit" id="resendCode" name="btn_guima" value="1">Gửi mã</button>
                    </div>
                </div>
                <div class="mb-3">
                <p class="text-danger fw-bold"><c:if test="${ not empty mes }">${mes}</c:if></p>
                <p class="text-primary fw-bold"><c:if test="${ not empty mes2 }">${mes2}</c:if></p>
                    <label for="inputCode" class="form-label me-3">Mã xác nhận</label>
                    <div class="d-flex">
                        <input type="text" id="inputCode" class="form-control w-100 me-2" placeholder="Nhập mã xác nhận"  name="ma_xn">
                       
                    </div>
                    

                </div>
                <div class="d-grid gap-2">
                    <button class="btn btn-primary" type="submit" name="btn_xacnhan" value="1">Xác nhận mã</button>
                </div>
            </form>
            <div class="text-center mt-3">
                <span>Quay lại trang </span>
                <a href="/asm2/views/Account?action=dang-nhap">Đăng nhập</a>
            </div>
        </div>
    </div>
</div>

</body>
</html>