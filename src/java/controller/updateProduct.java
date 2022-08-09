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
import java.util.List;
import modal.category;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "updateProduct", urlPatterns = {"/update"})
public class updateProduct extends HttpServlet {

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
            out.println("<title>Servlet updateProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProduct at " + request.getContextPath() + "</h1>");
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
//        try {
        productDAO cd = new productDAO();
        product d = cd.getProductIMG(img);
        if (d != null) {
//            request.setAttribute("s", s);
            request.setAttribute("data", d);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
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
        request.setCharacterEncoding("UTF-8");
//        processRequest(request, response);
        String id_raw = request.getParameter("id");
        String s = request.getParameter("s");
        String img = request.getParameter("img1");
        String title = request.getParameter("title");
        String price_raw = request.getParameter("price");
        String amount = request.getParameter("amount");

        productDAO c = new productDAO();

//        int quantity1;
//        try {
        int id, price, amount1;
        price = Integer.parseInt(price_raw);
        id = Integer.parseInt(id_raw);
        amount1 = Integer.parseInt(amount);
//            quantity1 = Integer.parseInt(quantity);
        product ct = c.getProductIMG(img);
//        if (c.checkExist1(id, img, title)) {
//            request.setAttribute("error", "Duplicate");
//            request.getRequestDispatcher("update.jsp").forward(request, response);
//        } else {
        product ct1;
        ct1 = new product(id, img, title, price, amount1, ct.getCategory(), "");
        c.update1(ct1);
        c.updatePrice(price_raw, img);
        c.updateTitle(title, img);
//        request.setAttribute("s", s);
        List<product> list1 = c.ChangeMoney(c.getAll1());
        request.setAttribute("data", list1);
        request.getRequestDispatcher("shopManage.jsp").forward(request, response);
//        }

//        } catch (ServletException | IOException | NumberFormatException e) {
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
