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
import java.util.List;
import modal.account;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "access", urlPatterns = {"/access"})
public class access extends HttpServlet {

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
            out.println("<title>Servlet access</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet access at " + request.getContextPath() + "</h1>");
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
//        String opt = request.getParameter("opt");
        String name = request.getParameter("user");
        HttpSession session = request.getSession();
        String name1 = (String) session.getAttribute("username");
        productDAO c = new productDAO();
//         List<product> list1 = c.getAll1();
        List<product> list3 = c.getProductByName(name1);
        accountDAO ac = new accountDAO();
        account acc = ac.getDuplicateAccountUser(name1);
        if (name1 != null) {
            if (acc.getRole() != 1) {
                int length = list3.size();
                request.setAttribute("length", length);

            }

//            if (opt.equals("")) {
//                request.setAttribute("user", name);
////                request.setAttribute("s", 0);
                request.getRequestDispatcher("index.jsp").forward(request, response);
//            } else {
//                int num = Integer.parseInt(opt);
//                if (num == 1) {
////                    request.setAttribute("s", 1);
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                } else {
////                    request.setAttribute("s", 0);
////                  request.setAttribute("data", list1);
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }
//            }
        } else {
//            if (opt.equals("")) {
//                request.setAttribute("user", name);
////                request.setAttribute("s", 0);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            } else {
//                int num = Integer.parseInt(opt);
//                if (num == 1) {
////                    request.setAttribute("s", 1);
//                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                } else {
////                    request.setAttribute("s", 0);
////                  request.setAttribute("data", list1);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
//                }
//            }
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
