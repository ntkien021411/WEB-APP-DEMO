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
import jakarta.servlet.http.Cookie;
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
public class login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("login.jsp").forward(request, response);

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
        response.setContentType("text/html;charset=UTF-8");
//        processRequest(request, response);
        String warning = "User or password invalid";
        String note = "Plese sign up account";
        //lay tu form use va pass
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String check = request.getParameter("check");
        HttpSession session = request.getSession();
//        // lay tu web.xml
//        String u_init = getServletContext().getInitParameter("user");
//        String p_init = getServletContext().getInitParameter("pass");
        accountDAO acd = new accountDAO();
        String name1 = (String) session.getAttribute("username");
        productDAO c = new productDAO();
        List<product> list3 = c.getProductByName(user);
        account acc = acd.getDuplicateAccountUser(user);
        if (acc.getRole() != 1) {
            int length = list3.size();
            request.setAttribute("length", length);
            session.setAttribute("role", 0);
        } else {
            session.setAttribute("role", 1);
        }

        session.setAttribute("acc", acc);

        if (acd.checkExist(user, pass)) {

            // luu vao session
            session.setAttribute("username", user);

            // tao Cookie lay thong tin cua nguoi dung de nho lai
            Cookie user1 = new Cookie("user", user);
            Cookie pass1 = new Cookie("pass", pass);
            Cookie check1 = new Cookie("rem", check);
            if (request.getParameter("check") != null) {
                user1.setMaxAge(60 * 60 * 24);
                pass1.setMaxAge(60 * 60 * 24);
                check1.setMaxAge(60 * 60 * 24);
            } else {
                user1.setMaxAge(0);
                pass1.setMaxAge(0);
                check1.setMaxAge(0);
            }
            response.addCookie(user1);
            response.addCookie(pass1);
            session.setAttribute("s", 1);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("error", warning);
            request.setAttribute("note", note);
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
