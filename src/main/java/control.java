/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns =
{
    "/control"
})
public class control extends HttpServlet
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
        
        int antal = Integer.parseInt(request.getParameter("antal"));
        double pris = Double.parseDouble(request.getParameter("pris"));
        HttpSession session = request.getSession();
        session.setAttribute("antal", antal);
        session.setAttribute("pris", pris);
        
        sum = antal * pris;
        if(sum >= 1000 && sum <=4999 ){
         sum = sum-(sum * 0.03);  
        }
        if(sum >= 5000 && sum <= 6999 ){
          sum = sum -(sum * 0.05);
        }
        if(sum >= 7000 && sum <= 9999){
            sum = sum - (sum * 0.07);
        }
        if(sum >= 10000 && sum <= 49999){
            sum = sum -(sum * 0.1);
        }
        if(sum > 5000){
            sum = sum -(sum * 0.15);
        }
        
        session.setAttribute("sum", sum);
        
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet control</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Total price:");
            out.println(sum + "<br><br>");
            out.println("<form action='state' method='POST' /> ");
            out.println("<input type='text' name='state' placeholder='State' />");
            out.println("<input type='submit' value='beregne' />");
            out.println("</form>");
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
