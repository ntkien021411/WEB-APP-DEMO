/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modal.category;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "updateQuantity", urlPatterns = {"/addquantity"})
public class updateQuantity extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateQuantity</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateQuantity at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
//        processRequest(request, response);
        String img = request.getParameter("img");
//        String s = request.getParameter("s");
        int  quantity;
        try {
            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("username");
            productDAO cd = new productDAO();
            product c = cd.checkDuplicate(img, name);
            if (c != null) {
                quantity = c.getQuantity() + 1;
                product ct1 = new product(0, img, "", 0, quantity, c.getCategory(), name);
                cd.update(ct1);
//                request.setAttribute("s", s);
                request.getRequestDispatcher("shop").forward(request, response);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
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
//        request.setCharacterEncoding("UTF-8");
//        String id_raw = request.getParameter("id");
//        String quantity_raw = request.getParameter("quantity");
//        productDAO c = new productDAO();
//        int id, quantity;
//        try {
//            id = Integer.parseInt(id_raw);
//            quantity = Integer.parseInt(quantity_raw);
//            product ct1 = new product(id, "", "", 0, quantity + 1);
//            c.update(ct1);
//            response.sendRedirect("shop");
//        } catch (Exception e) {
//            System.out.println(e);
//        }
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
