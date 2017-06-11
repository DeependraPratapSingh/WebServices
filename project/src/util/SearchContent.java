/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dbconn.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;



/**
 *
 * @author Rishabh
 */
public class SearchContent extends HttpServlet {

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
    	PreparedStatement pstmt = null;
    	String filter = " and pet_name like '%"+request.getParameter("name")+"' and city like '%"+request.getParameter("city")+"' and pet_type like '%"+request.getParameter("type")+"'";
    	 
    	try
        {
           String s = "";
           JSONArray jaobj = new JSONArray();
           pstmt = DBUtil.createConnection().prepareStatement("select pet_name from pets where 1 "+filter);
           
           ResultSet rs = pstmt.executeQuery();
           PrintWriter out = response.getWriter();
           while(rs.next())
           {
               JSONObject jobj = new JSONObject();
               jobj.put("name",rs.getString(1));
               jaobj.put(jobj);
           }
           
           out.print(jaobj);
           
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
    	
    	
    
    	try
        {
           
           JSONArray jaobj = new JSONArray();
           JSONArray city = new JSONArray();
           JSONArray type = new JSONArray();
           ResultSet rs = DBUtil.createConnection().createStatement().executeQuery("select distinct(city) from pets where 1 ");
           
           
           PrintWriter out = response.getWriter();
           while(rs.next())
           {
               JSONObject jobj = new JSONObject();
               jobj.put("city",rs.getString(1));
               city.put(jobj);
           }
           
           rs = DBUtil.createConnection().createStatement().executeQuery("select distinct(pet_type) from pets where 1 ");
           
           
           while(rs.next())
           {
               JSONObject jobj = new JSONObject();
               jobj.put("type",rs.getString(1));
               type.put(jobj);
           }
           
           jaobj.put(city);
           jaobj.put(type);
           out.print(jaobj);
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
