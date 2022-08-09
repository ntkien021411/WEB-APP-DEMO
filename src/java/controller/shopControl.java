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
import java.util.ArrayList;
import java.util.List;
import modal.account;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "shopControl", urlPatterns = {"/shop"})
public class shopControl extends HttpServlet {

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
            out.println("<title>Servlet shopControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet shopControl at " + request.getContextPath() + "</h1>");
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
        String num = request.getParameter("s");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        productDAO c = new productDAO();
        List<product> list = c.getProductByName(name);
        List<product> list1 = c.ChangeMoney(c.getAll1());
        List<product> list2 = c.ChangeTotal(c.ChangeMoney(c.getProductByName(name)));
        accountDAO ad = new accountDAO();
        account ac = ad.getDuplicateAccountUser(name);
        int check = ac.getRole();
        int b = check;
        int total = 0;
        for (product item : list) {
            total += (item.getQuantity() * item.getPrice());
        }
        String money = c.ChangeOneMoney(total);
        if (b != 1) {
//            request.setAttribute("s1", num);
            request.setAttribute("total", money);
            request.setAttribute("data", list2);
            request.getRequestDispatcher("shop.jsp").forward(request, response);
        } else {
//            request.setAttribute("s1", num);
            request.setAttribute("data", list1);
            request.getRequestDispatcher("shopManage.jsp").forward(request, response);
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
//        processRequest(request, response);
//        String num = request.getParameter("s");
        productDAO c = new productDAO();
        List<product> list = c.getAll();
        int total = 0;
        for (product item : list) {
            total += (item.getQuantity() * item.getPrice());
        }
//        request.setAttribute("s1", num);
        request.setAttribute("total", total);
        request.setAttribute("data", list);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
