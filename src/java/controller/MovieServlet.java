/*
 * This servlet acts as a controller to get access to different methods
 * of lookup
 */
package controller;

import Lookup.movieFinder;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aben
 */
@WebServlet(name = "MovieServlet", urlPatterns = {"/MovieServlet"})
public class MovieServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        movieFinder mf = new movieFinder(); /* instance of movieFinder */
        
        String type = request.getParameter("type");
        String title;

        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
       
        switch (type) {
            case "store":
                int storeID = Integer.parseInt(request.getParameter("store_id"));
                title = request.getParameter("title");
                response.getWriter().write(mf.lookUpByStoreID(storeID, title).toString()); //Look up by store id and title
                break;
            case "title":
                title = request.getParameter("title");
                response.getWriter().write(mf.lookupByTitle(title).toString()); //Look up by title
                break;
            case "inventory":
                int invID = Integer.parseInt(request.getParameter("inv_id")); 
                response.getWriter().write(mf.lookupByInvID(invID).toString()); //Look up by inventory id
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
