package ru.lanit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/surname")
public class SurnameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");
        String surname = request.getParameter("surname");
        session.setAttribute("surname", surname);

        response.sendRedirect(request.getContextPath() + "/total");
    }
}


