<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 450px; border-radius: 15px;">
        <h3 class="text-center mb-4">Tạo tài khoản mới</h3>

        <!-- Thông báo lỗi -->
        <c:if test="${not empty alert}">
            <div class="alert alert-danger text-center">${alert}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/register" method="post">
            <div class="mb-3">
                <label class="form-label">Tài khoản</label>
                <input type="text" name="username" class="form-control" placeholder="Nhập tên tài khoản" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input type="password" name="password" class="form-control" placeholder="Nhập mật khẩu" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" name="email" class="form-control" placeholder="Nhập email" required>
            </div>
            <button type="submit" class="btn btn-success w-100">Đăng ký</button>
        </form>

        <p class="text-center mt-3">
            Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập ngay</a>
        </p>
    </div>
</div>

</body>
</html>
