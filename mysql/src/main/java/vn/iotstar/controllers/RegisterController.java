package vn.iotstar.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.models.Usermodel;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserService;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Usermodel user = new Usermodel();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        if (userService.insertUser(user)) {
            response.sendRedirect("login"); // đăng ký xong quay lại login
        } else {
            request.setAttribute("alert", "Tên tài khoản đã tồn tại!");
            request.getRequestDispatcher("/views/register.jsp").forward(request, response);
        }
    }
}


