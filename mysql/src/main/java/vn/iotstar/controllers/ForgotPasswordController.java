package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.Usermodel;
import vn.iotstar.services.impl.UserService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/forget-password")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/forget_password.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        IUserService service = new UserService();
        Usermodel user = service.get(username);
        String alertMsg = "";
        if (user != null && user.getEmail().equals(email)) {
            // For demo: reset password to "1234567" and show message
            service.resetPassword(username, "1234567");
            alertMsg = "Mật khẩu đã được đặt lại về 1234567. Vui lòng đăng nhập lại.";
        } else {
            alertMsg = "Thông tin không đúng. Vui lòng kiểm tra lại.";
        }
        req.setAttribute("alert", alertMsg);
        req.getRequestDispatcher("/forget_password.jsp").forward(req, resp);
    }
}
