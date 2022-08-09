/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.accountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modal.account;

/**
 *
 * @author asus
 */
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("register.jsp").forward(request, response);
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

        //lay tru form use va pass
        String user = request.getParameter("user1");
        String pass = request.getParameter("pass1");
        String repass = request.getParameter("repass1");
        String choice =  request.getParameter("choice");
        accountDAO ac = new accountDAO();
//        if (ac.getDuplicateAccountUser(user) != null) {
//            check  = "1";
////            if (pass.equals(repass)) {
////                account ac1 = new account(user, pass);
////                ac.addDataTable(ac1);
////                request.getRequestDispatcher("login.jsp").forward(request, response);
//////             add vào database
////            } else {
//            request.setAttribute("check", check);
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//
////            }
//        } else {
//            check  = "2";
//            String warning = "Repass is not the same as pass";
//            String note = "Plese fill again";
////            if (pass.equals(repass)) {
//                request.setAttribute("check", check);
//                request.getRequestDispatcher("register.jsp").forward(request, response);
////            }
//        }
        try {
            if (ac.getDuplicate(user) == true) {
                if (!pass.equals(repass)) {
                    String warning = "Repass is not the same as pass and account is duplicate";
                    String note = "Plese fill again";
                    request.setAttribute("warning", warning);
                    request.setAttribute("note", note);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    String warning = "Account is duplicate";
                    String note = "Plese fill again";
                    request.setAttribute("warning", warning);
                    request.setAttribute("note", note);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
            } else {
                int role = Integer.parseInt(choice);
                if (!pass.equals(repass)) {
                    String warning = "Repass is not the same as pass";
                    String note = "Plese fill again";
                    request.setAttribute("warning", warning);
                    request.setAttribute("note", note);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    account ac1 = new account(user, pass,role);
                    ac.addDataTable(ac1);
                    String success = "Sign up successfull";
                    String note = "Congratulation!";
                    request.setAttribute("success", success);
                    request.setAttribute("note", note);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
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
