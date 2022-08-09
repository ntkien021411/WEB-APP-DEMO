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
import java.util.Date;
import java.util.List;
import modal.category;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "addByAdmin", urlPatterns = {"/addByAdmin"})
public class addByAdmin extends HttpServlet {

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
            out.println("<title>Servlet addByAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addByAdmin at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("add.jsp").forward(request, response);

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

        String id_raw = request.getParameter("id");
        String img = request.getParameter("img1");
        String title = request.getParameter("title");
        String price_raw = request.getParameter("price");
        String amount = request.getParameter("amount");
        String choice = request.getParameter("type");
        productDAO c = new productDAO();
        int id, price, amount1;
        price = Integer.parseInt(price_raw);
        id = Integer.parseInt(id_raw);

        amount1 = Integer.parseInt(amount);
        category ct;
        switch (choice) {
            case "1":
                ct = c.getCategoryID(1);
                img = "img/product/2" + img;
                break;
            case "2":
                ct = c.getCategoryID(2);
                img = "img/product3/" + img;
                break;
            case "3":
                ct = c.getCategoryID(3);
                img = "img/product4/" + img;
                break;
            default:
                ct = c.getCategoryID(4);
                img = "img/product1/" + img;
                break;
        }

        if (c.checkExist1(id)) {
            request.setAttribute("error", "Duplicate");
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else {
            product ct1 = new product(id, img, title, price, amount1, ct, "");
            c.addDataTable1(ct1);
//            request.setAttribute("s1", 1);
            List<product> list1 = c.ChangeMoney(c.getAll1());
            request.setAttribute("data", list1);
            request.getRequestDispatcher("shopManage.jsp").forward(request, response);
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
