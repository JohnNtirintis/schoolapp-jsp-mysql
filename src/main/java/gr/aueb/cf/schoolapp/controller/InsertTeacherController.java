package gr.aueb.cf.schoolapp.controller;

import gr.aueb.cf.schoolapp.dao.ITeacherDAO;
import gr.aueb.cf.schoolapp.dao.TeacherDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.service.ITeacherService;
import gr.aueb.cf.schoolapp.service.TeacherServiceImpl;
import gr.aueb.cf.schoolapp.validator.TeacherValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Ntirintis John
 */
@WebServlet("/schoolapp/insert")
public class InsertTeacherController extends HttpServlet {
    private final ITeacherDAO teacherDAO = new TeacherDAOImpl();
    private final ITeacherService teacherService = new TeacherServiceImpl(teacherDAO);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("isError", false);
//        request.setAttribute("teachersNotFound", false);
//        request.setAttribute("error", "");
//        request.getRequestDispatcher("/static/templates/teachersmenu.jsp").forward(request, response);

        request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", "");

        String firstName = request.getParameter("firstname").trim();
        String lastname = request.getParameter("lastname").trim();

        TeacherInsertDTO teacherInsertDTO = new TeacherInsertDTO();
        teacherInsertDTO.setFirstname(firstName);
        teacherInsertDTO.setLastname(lastname);

        try {
            Map<String, String> errors = TeacherValidator.validate(teacherInsertDTO);
            if(!errors.isEmpty()){
                String firstNameMessage = (errors.get("firstname") != null) ? "Firstname" + errors.get("firstname") : " ";
                String lastNameMessage = (errors.get("lastname") != null) ? "Lastname" + errors.get("lastname") : " ";
                request.setAttribute("error", firstNameMessage + " " + lastNameMessage);
                request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
                // return so it doesn't insert
                return;
            }

            Teacher teacher = teacherService.insertTeacher(teacherInsertDTO);
            request.setAttribute("insertedTeacher", teacher);
            request.getRequestDispatcher("/static/templates/teacherInserted.jsp").forward(request, response);
        } catch (TeacherDAOException e){
            request.setAttribute("sqlError", true);
            request.setAttribute("message", e.getMessage());
//            request.getRequestDispatcher("static/templates/teachersmenu.jsp");
            request.getRequestDispatcher("/schoolapp/menu").forward(request, response);
        }

    }
}
