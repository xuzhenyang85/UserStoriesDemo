
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "state", urlPatterns =
{
    "/state"
})
public class state extends HttpServlet
{
    double sum;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        
        int antal = Integer.parseInt(session.getAttribute("antal").toString());
        double pris = Double.parseDouble(session.getAttribute("pris").toString());
        
        sum = Double.parseDouble(session.getAttribute("sum").toString());
        String state = request.getParameter("state");
        
        if(state.equals("UT") || state.equals("ut") ){
            sum = sum + (sum * 0.0685);
        }
        if(state.equals("NV") || state.equals("nv")){
            sum = sum + (sum * 0.08);
        }
        if(state.equals("TX") || state.equals("tx")){
            sum = sum + (sum * 0.0625);
        }
        if(state.equals("AL") || state.equals("al")){
            sum = sum + (sum * 0.04);
        }
        if(state.equals("CA") || state.equals("ca")){
            sum = sum + (sum * 0.0825);
        }
        else{
            //response.sendRedirect("control");
        }
        
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet state</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Intast antal: "+antal+"</h3>");
            out.println("<h3>Intast pris: "+pris+"</h3>");
            out.println("<h3>Intast state: "+state+"</h3>");
            out.println("<h2>Pris inkl. moms " + sum + ",-</h2>");
            out.println("");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
