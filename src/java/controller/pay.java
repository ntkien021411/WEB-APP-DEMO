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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.order;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "pay", urlPatterns = {"/pay"})
public class pay extends HttpServlet {

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
            out.println("<title>Servlet pay</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pay at " + request.getContextPath() + "</h1>");
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

        List<product> list1 = c.getProductByName(name);
        String email = request.getParameter("emailUser");
        String phone = request.getParameter("phoneUser");
        String address = request.getParameter("addressUser");
        String dateOrder = request.getParameter("dateNow");
        int id;
        List<order> list = c.getAllOrder();
        int code = 0;
        if (list.isEmpty()) {
            id = 1;
            code = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
            code = list.get(list.size() - 1).getCodeOrder() + 1;
        }

        int total = 0;
        for (product item : list1) {
            total += (item.getQuantity() * item.getPrice());
        }
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
        List<order> listOrder = new ArrayList<>();
        int num = id;
        for (product item : list1) {
            order od = new order();
            od.setId(num);
            od.setPrice(item.getPrice());
            od.setImg(item.getImg());
            od.setTitle(item.getTitle());
            od.setQuantity(item.getQuantity());
            od.setUserName(name);
            od.setCategory(item.getCategory());
            int sumProduct = item.getQuantity() * item.getPrice();
            od.setPriceSumProduct(sumProduct);
            od.setPriceSum(total);
            od.setEmail(email);
            od.setAddress(address);
            od.setPhoneNumber(phone);
            od.setCodeOrder(code);
            Date d;
            try {
                d = f.parse(dateOrder);
                od.setDateOrder(d);
            } catch (ParseException ex) {
                Logger.getLogger(pay.class.getName()).log(Level.SEVERE, null, ex);
            }
            listOrder.add(od);
            num++;
        }
        c.insertOrder(listOrder);
//        c.deleteAllProduct(name);
//        request.setAttribute("data", listOrder);
        request.getRequestDispatcher("access").forward(request, response);

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
