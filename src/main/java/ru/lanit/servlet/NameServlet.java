package ru.lanit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/name")
public class NameServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        session.setAttribute("name", name);

        response.sendRedirect(request.getContextPath() + "/patronymic.jsp");
    }
}

