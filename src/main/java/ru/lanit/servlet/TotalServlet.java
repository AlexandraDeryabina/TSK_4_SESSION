package ru.lanit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/total")
public class TotalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        request.setCharacterEncoding("utf-8");
        String name = session.getAttribute("name").toString();
        String surname = session.getAttribute("surname").toString();
        String patronymic = session.getAttribute("patronymic").toString();

        request.setAttribute("name", name);
        request.setAttribute("surname", surname);
        request.setAttribute("patronymic", patronymic);

        request.getRequestDispatcher("total.jsp").forward(request, response);
    }
}


