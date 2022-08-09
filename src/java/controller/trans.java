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
public class trans extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet trans</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet trans at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        productDAO c = new productDAO();
        String change = request.getParameter("trans");
        int num = Integer.parseInt(change);
        List<product> list = c.getAll2(num);
        List<product> list3 = c.ChangeMoney(c.getProductByName(name));
        //format money
        List<product> listAfterFormat = c.ChangeMoney(list);
//        List<product> listAfterFormat = new ArrayList<>();
//        for (product item : list) {
//            String money = Integer.toString(item.getPrice());
//            List<String> list1 = new ArrayList<>();
//            int length = money.length();
//            int count = 0;
//            for (int i = length - 1; i >= 0; i--) {
//                String cd = money.charAt(i) + "";
//                list1.add(cd);
//                count++;
//                if (count == 3) {
//                    list1.add(",");
//                    count = 0;
//                }
//            }
//            if (list1.get(list1.size() - 1).equals(",")) {
//                list1.remove(list1.size() - 1);
//            }
//            String price1 = "";
//            for (int i = list1.size() - 1; i >= 0; i--) {
//                price1 += list1.get(i);
//            }
//            product p1 = new product(item.getId(),
//                    item.getImg(), item.getTitle(), price1,
//                    item.getQuantity(),
//                    item.getCategory(),
//                    item.getPrice());
//            listAfterFormat.add(p1);
//
//        }
        /// format money
        accountDAO ac = new accountDAO();
        account acc = ac.getDuplicateAccountUser(name);
        if (name != null) {
            if (acc.getRole() != 1) {
                int length = list3.size();
                request.setAttribute("length", length);
                request.setAttribute("data1", list3);

            }
            request.setAttribute("data", listAfterFormat);
            change += "";
            String change_raw = "";
            if (change.equals("4")) {

                change_raw = "4";
            }
            if (change.equals("3")) {

                change_raw = "3";
            }
            if (change.equals("1")) {

                change_raw = "1";
            }
            if (change.equals("2")) {
                change_raw = "2";
            }
            if (change_raw.equalsIgnoreCase("4")) {

                request.getRequestDispatcher("product4.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("3")) {
                request.getRequestDispatcher("product3.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("1")) {

                request.getRequestDispatcher("product1.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("2")) {
                request.getRequestDispatcher("product2.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("data", listAfterFormat);
            change += "";
            String change_raw = "";
            if (change.equals("4")) {

                change_raw = "4";
            }
            if (change.equals("3")) {

                change_raw = "3";
            }
            if (change.equals("1")) {

                change_raw = "1";
            }
            if (change.equals("2")) {
                change_raw = "2";
            }
            if (change_raw.equalsIgnoreCase("4")) {

                request.getRequestDispatcher("product4.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("3")) {
                request.getRequestDispatcher("product3.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("1")) {

                request.getRequestDispatcher("product1.jsp").forward(request, response);
            }
            if (change_raw.equalsIgnoreCase("2")) {
                request.getRequestDispatcher("product2.jsp").forward(request, response);
            }
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
