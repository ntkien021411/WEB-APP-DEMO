/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accountDAO;
import dal.productDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.account;
import modal.order;
import modal.popularProduct;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "InforShop", urlPatterns = {"/InforShop"})
public class InforShop extends HttpServlet {

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
            out.println("<title>Servlet InforShop</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InforShop at " + request.getContextPath() + "</h1>");
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
        accountDAO acd = new accountDAO();
        productDAO c = new productDAO();
        HttpSession session = request.getSession();
        int userQuantity = acd.calculateUserQuantity();
        product pMax = c.ChangeMoneyProduct(c.findMaxPriceListProduct());
         product pMin =c.ChangeMoneyProduct(c.findMinPriceListProduct());
         session.setAttribute("maxP", pMax);
         session.setAttribute("minP", pMin);
        try {
            popularProduct p = c.findPopularProduct();
            int quantiyPpProduct = p.getQuantity();
            String imgPpProduct = p.getImg();
            session.setAttribute("qP", quantiyPpProduct);
            session.setAttribute("imgP", imgPpProduct);
        } catch (SQLException ex) {
            Logger.getLogger(InforShop.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            int orderQuantity = c.calculateOrderQuantity();
            session.setAttribute("orderQ", orderQuantity);
        } catch (SQLException ex) {
            Logger.getLogger(InforShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        int allProductQuantity = c.calculateProductQuantity();
        session.setAttribute("userQ", userQuantity);
        session.setAttribute("allPQ", allProductQuantity);
        session.setAttribute("role", 1);
        request.getRequestDispatcher("inforshop.jsp").forward(request, response);
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
//        processRequest(request, response);
        HttpSession session = request.getSession();
        accountDAO acd = new accountDAO();
        productDAO c = new productDAO();
        try {
            int userTakeOrder = acd.quantityUserTakeOrder();
            session.setAttribute("userTakeOrder", userTakeOrder);
        } catch (SQLException ex) {
            Logger.getLogger(InforShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int productOrder = c.calculateProductQuantityWithProductInOrder();
       session.setAttribute("productOrder", productOrder);
        } catch (SQLException ex) {
            Logger.getLogger(InforShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int orderOverTarget = c.calculateOrderOvertargets();
       session.setAttribute("orderOverTarget", orderOverTarget);
        } catch (SQLException ex) {
            Logger.getLogger(InforShop.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("role", 0);
        request.getRequestDispatcher("inforshop.jsp").forward(request, response);
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
