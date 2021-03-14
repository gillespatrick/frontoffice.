package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gillios
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        // Work work = new Catalogue.listOfWorks.stream().filter(w -> w.getId() == Long.parseLong(id).findFirst().get());

        Work work = null;
        for (Work nexWork : Catalogue.listOfWork) {
            if (nexWork.getId() == Long.parseLong(id));
            {
                work = nexWork;
                break;
            }
        }
        request.setAttribute("work", work);
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/work-details.jsp");
        disp.forward(request, response);
      

    }

}
