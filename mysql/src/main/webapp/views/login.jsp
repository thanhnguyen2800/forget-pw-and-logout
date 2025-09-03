<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 400px; border-radius: 15px;">
        <h3 class="text-center mb-4">Đăng nhập</h3>

        <!-- Thông báo lỗi -->
        <c:if test="${not empty alert}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>

        <form action="login" method="post">
            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" name="uname" class="form-control" placeholder="Nhập tên tài khoản" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" name="psw" class="form-control" placeholder="Nhập mật khẩu" required>
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" name="remember" class="form-check-input" id="remember">
                <label class="form-check-label" for="remember">Ghi nhớ đăng nhập</label>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>

        <p class="text-center mt-3">
            Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a>
        </p>
        <p class="text-center">
            Quên mật khẩu? <a href="forgot">Khôi phục</a>
        </p>
    </div>
</div>

</body>
</html>
