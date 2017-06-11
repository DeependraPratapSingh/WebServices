/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoUser;
import dto.DtoUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rishabh
 */
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession hs = request.getSession();
        try
        {
        if(hs.isNew() || hs.getAttribute("user") == null)
        {
            request.getRequestDispatcher("/index.jsp?body=login.jsp").forward(request, response);
        }
        else if(hs.getAttribute("user") != null)
        {
            request.setAttribute("body", "home.jsp");
            request.getRequestDispatcher("index.jsp?body=home.jsp").forward(request, response);
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession hs = request.getSession();
        String type = (String)request.getParameter("type");
        DtoUser obj = new DtoUser();
        DaoUser dobj = new DaoUser();
        if(type.equals("reg") && request.getParameter("password").equals(request.getParameter("cpassword")))
        {
            obj.setName(request.getParameter("name"));
            obj.setUsername(request.getParameter("username"));
            obj.setPassword(request.getParameter("password"));
            if(dobj.register(obj) > 0)
            	request.getRequestDispatcher("index.jsp?body=home.jsp").forward(request, response);
            else
            {
            	request.getRequestDispatcher("index.jsp?body=regerr.jsp").forward(request, response);
            }
        }
        else if(type.equals("val"))
        {
            request.setAttribute("body", "home.jsp");
            obj.setUsername(request.getParameter("username"));
            obj.setPassword(request.getParameter("password"));
            if(dobj.validate(obj))
            {
            	hs.setAttribute("user", "true");
            	request.getRequestDispatcher("index.jsp?body=home.jsp").forward(request, response);
            }
            else
            {
            	request.getRequestDispatcher("index.jsp?body=valerr.jsp").forward(request, response);
            }
        }   
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
