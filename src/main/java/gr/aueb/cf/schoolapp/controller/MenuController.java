package gr.aueb.cf.schoolapp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ntirintis John
 */
@WebServlet("/schoolapp/menu")
public class MenuController  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Comment these 3 lines in case of error
        request.setAttribute("sqlError", false);
        request.setAttribute("teachersNotFound", false);
        request.setAttribute("error", "");

        request.getRequestDispatcher("/static/templates/teachersmenu.jsp").forward(request, response);
    }
}
