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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modal.account;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "sortProduct", urlPatterns = {"/sort"})
public class sortProduct extends HttpServlet {

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
            out.println("<title>Servlet sortProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet sortProduct at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        productDAO c = new productDAO();
        String choice = request.getParameter("sorttype");
        String change = request.getParameter("trans");
        String price = request.getParameter("price");
//        if (choice != null) {
        int numBefore = Integer.parseInt(price);
        session.setAttribute("priceBefore", numBefore);
//        }
//        if (price != null) {
        int num1Before = Integer.parseInt(choice);
        session.setAttribute("choiceBefore", num1Before);
//        }

        if (change.equals("5")) {
            List<product> list4 = c.ChangeMoney(c.getProductByName(name));
            int length = list4.size();
            request.setAttribute("length", length);
            request.setAttribute("data1", list4);
            List<product> list1 = (List<product>) session.getAttribute("datas");
            if (choice.equals("1")) {
                Collections.sort(list1, (product o1, product o2) -> {
                    //sort increase by name
                    // compare two object
                    // if o1 < o2
                    if (o1.getPrice() < o2.getPrice()) {
                        // return value -1
                        return -1;
                        // if o1 = o2
                    } else if (o1.getPrice() == o2.getPrice()) {
                        // return value 0
                        return 0;
                    } else { // if o1 > o2
                        // return value 1
                        return 1;
                    }
                });

                List<product> listAfterFormat1 = c.ChangeMoney(list1);
                session.setAttribute("datas", listAfterFormat1);
            } else if (choice.equals("2")) {
                Collections.sort(list1, (product o1, product o2) -> {
                    //sort increase by name
                    // compare two object
                    // if o1 < o2
                    if (o1.getPrice() > o2.getPrice()) {
                        // return value -1
                        return -1;
                        // if o1 = o2
                    } else if (o1.getPrice() == o2.getPrice()) {
                        // return value 0
                        return 0;
                    } else { // if o1 > o2
                        // return value 1
                        return 1;
                    }
                });
                List<product> listAfterFormat1 = c.ChangeMoney(list1);
                session.setAttribute("datas", listAfterFormat1);
            } else {
                List<product> list3 = c.getAll1();
                List<product> list2 = c.ChangeMoney(list3);
                session.setAttribute("datas", list2);
            }

            request.getRequestDispatcher("search.jsp").forward(request, response);
        } else {
            int num = Integer.parseInt(change);
            List<product> listPrice = new ArrayList<>();
            List<product> list = c.getAll2(num);
            if (price.equals("0")) {
                for (product item : list) {
                    if (item.getPrice() < 1000000) {
                        listPrice.add(item);
                    }
                }
                list = listPrice;
            } else if (price.equals("1")) {
                for (product item : list) {
                    if (item.getPrice() > 1000000) {
                        listPrice.add(item);
                    }
                }
                list = listPrice;
            } else if (price.equals("2")) {
                for (product item : list) {
                    if (item.getPrice() > 3000000) {
                        listPrice.add(item);
                    }
                }
                list = listPrice;
            }
            accountDAO ac = new accountDAO();
            account acc = ac.getDuplicateAccountUser(name);
            List<product> list3 = c.ChangeMoney(c.getProductByName(name));
            List<product> listAfterFormat = c.ChangeMoney(c.sortProduct(list, choice));
            request.setAttribute("data", listAfterFormat);
            if (name != null) {
                if (acc.getRole() != 1) {
                    int length = list3.size();
                    request.setAttribute("length", length);
                    request.setAttribute("data1", list3);

                }
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
