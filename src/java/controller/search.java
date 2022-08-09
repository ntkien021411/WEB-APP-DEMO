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
import modal.category;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

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
            out.println("<title>Servlet search</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search at " + request.getContextPath() + "</h1>");
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
//        String s1 = request.getParameter("s1");
        String choice = request.getParameter("type");
        String choice1 = request.getParameter("MMprice");
        String price = request.getParameter("priceFrom");
//        String priceTo = request.getParameter("priceTo");
        String nameP = request.getParameter("nameP");
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("username");
        List<product> list;
        accountDAO ac = new accountDAO();
        account acc = ac.getDuplicateAccountUser(name);
        if (name != null) {
            if (acc.getRole() != 1) {
                productDAO c = new productDAO();
                List<product> list1 = c.ChangeMoney(c.getProductByName(name));
                int length = list1.size();
                request.setAttribute("length", length);
                request.setAttribute("data1", list1);
            }
        }
        if (choice.equals("0") && choice1.equals("0")
                && price.equals("") 
                && nameP.equals("")) {
            productDAO c = new productDAO();
            List<product> list1 = c.getAll1();
            List<product> list2 = c.ChangeMoney(list1);
//            request.setAttribute("s", s1);
            session.setAttribute("datas", list2);
            request.getRequestDispatcher("search.jsp").forward(request, response);
        } else {
            productDAO c = new productDAO();
            // chon moi loai product thi chi tim product do
            if (!choice.equals("0") && choice1.equals("0")
                    && price.equals("")  && nameP.equals("")) {
                category ct;
                switch (choice) {
                    case "1":
                        ct = c.getCategoryID(1);
                        break;
                    case "2":
                        ct = c.getCategoryID(2);

                        break;
                    case "3":
                        ct = c.getCategoryID(3);
                        break;
                    default:
                        ct = c.getCategoryID(4);
                        break;
                }
                product p = new product(0, "", "", 0, 0, ct);
                list = c.getAllByTID(p);
//                request.setAttribute("s", s1);

                List<product> list2 = c.ChangeMoney(list);
                session.setAttribute("datas", list2);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }
            // chon moi gia nho va lon  thi tim product co gia nho va lon
            if (choice.equals("0") && !choice1.equals("0")
                    && price.equals("") && nameP.equals("")) {
                if (choice1.equals("1")) {
                    product p1 = new product(0, "", "", c.findMaxPrice(), 0, new category());
                    List<product> list1 = c.getAllByPrice(p1);
//                    request.setAttribute("s", s1);
                    List<product> list2 = c.ChangeMoney(list1);
                    session.setAttribute("datas", list2);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                } else {
                    product p1 = new product(0, "", "", c.findMinPrice(), 0, new category());
                    List<product> list1 = c.getAllByPrice(p1);
//                    request.setAttribute("s", s1);
                    List<product> list2 = c.ChangeMoney(list1);
                    session.setAttribute("datas", list2);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                }
            }
            // chon loai product va gia nho lon 
            // product co gia nho va lon 
            if (!choice.equals("0") && !choice1.equals("0")
                    && price.equals("")  && nameP.equals("")) {
                category ct;

                if (choice1.equals("1")) {
                    int priceTID;
                    switch (choice) {
                        case "1":
                            ct = c.getCategoryID(1);
                            priceTID = c.findMaxPriceByTID(1);
                            break;
                        case "2":
                            ct = c.getCategoryID(2);
                            priceTID = c.findMaxPriceByTID(2);
                            break;
                        case "3":
                            ct = c.getCategoryID(3);
                            priceTID = c.findMaxPriceByTID(3);
                            break;
                        default:
                            ct = c.getCategoryID(4);
                            priceTID = c.findMaxPriceByTID(4);
                            break;
                    }
                    product p1 = new product(0, "", "", priceTID, 0, ct);
                    List<product> list1 = c.getAllByTIDAndPRICE(p1);
//                    request.setAttribute("s", s1);
                    List<product> list2 = c.ChangeMoney(list1);
                    session.setAttribute("datas", list2);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                } else if (choice1.equals("2")) {
                    int priceTID;
                    switch (choice) {
                        case "1":
                            ct = c.getCategoryID(1);
                            priceTID = c.findMinPriceByTID(1);
                            break;
                        case "2":
                            ct = c.getCategoryID(2);
                            priceTID = c.findMinPriceByTID(2);
                            break;
                        case "3":
                            ct = c.getCategoryID(3);
                            priceTID = c.findMinPriceByTID(3);
                            break;
                        default:
                            ct = c.getCategoryID(4);
                            priceTID = c.findMinPriceByTID(4);
                            break;
                    }
                    product p1 = new product(0, "", "", priceTID, 0, ct);
                    List<product> list1 = c.getAllByTIDAndPRICE(p1);
//                    request.setAttribute("s", s1);
                    List<product> list2 = c.ChangeMoney(list1);
                    session.setAttribute("datas", list2);
                    request.getRequestDispatcher("search.jsp").forward(request, response);
                }

            }

            // chon type product và chon gia và ch?n giá lon nho
            // product co gia nho hon gia chon 
            if (!choice.equals("0") && !choice1.equals("0")
                    && !price.equals("")  && nameP.equals("")) {
                category ct;
                int priceP = Integer.parseInt(price);
                switch (choice) {
                    case "1":
                        ct = c.getCategoryID(1);
                        break;
                    case "2":
                        ct = c.getCategoryID(2);
                        break;
                    case "3":
                        ct = c.getCategoryID(3);
                        break;
                    default:
                        ct = c.getCategoryID(4);
                        break;
                }
                product p1 = new product(0, "", "", priceP, 0, ct);
                List<product> list1 = c.getAllByTIDAndSmallerPRICE(p1);
//                request.setAttribute("s", s1);
                List<product> list2 = c.ChangeMoney(list1);
                session.setAttribute("datas", list2);
                request.getRequestDispatcher("search.jsp").forward(request, response);

            }
            // chon type product và chon gia 
            // product co gia nho hon gia chon 
            if (!choice.equals("0") && choice1.equals("0")
                    && !price.equals("")  && nameP.equals("")) {
                category ct;
                int priceP = Integer.parseInt(price);
                switch (choice) {
                    case "1":
                        ct = c.getCategoryID(1);
                        break;
                    case "2":
                        ct = c.getCategoryID(2);
                        break;
                    case "3":
                        ct = c.getCategoryID(3);
                        break;
                    default:
                        ct = c.getCategoryID(4);
                        break;
                }
                product p1 = new product(0, "", "", priceP, 0, ct);
                List<product> list1 = c.getAllByTIDAndSmallerPRICE(p1);
//                request.setAttribute("s", s1);
                List<product> list2 = c.ChangeMoney(list1);
                session.setAttribute("datas", list2);
                request.getRequestDispatcher("search.jsp").forward(request, response);

            }
            // chon  gia 
            // tat ca product co gia nho hon gia chon 
            if (choice.equals("0") && choice1.equals("0")
                    && !price.equals("") && nameP.equals("")) {
                int priceP = Integer.parseInt(price);
                product p1 = new product(0, "", "", priceP, 0, new category());
                List<product> list1 = c.getAllBySmallerPRICE(p1);
//                request.setAttribute("s", s1);
                List<product> list2 = c.ChangeMoney(list1);
                session.setAttribute("datas", list2);
                request.getRequestDispatcher("search.jsp").forward(request, response);

            }
            // chon  2 gia 
            // tat ca product co gia tu gia den gia 
//            if (choice.equals("0") && choice1.equals("0")
//                    && !price.equals("")) {
//                int priceP = Integer.parseInt(price);
////                int priceT = Integer.parseInt(priceTo);
//                product p1 = new product(0, "", "", priceP, 0, new category());
//                List<product> list1 = c.getAllByFromToPRICE(p1, priceT);
////                request.setAttribute("s", s1);
//                List<product> list2 = c.ChangeMoney(list1);
//                session.setAttribute("datas", list2);
//                request.getRequestDispatcher("search.jsp").forward(request, response);
//
//            }

//            // chon  2 gia  và ch?n type 
//            //  product co gia tu gia den gia 
//            if (!choice.equals("0") && choice1.equals("0")
//                    && !price.equals("")  && nameP.equals("")) {
//                category ct;
//                int priceP = Integer.parseInt(price);
//                switch (choice) {
//                    case "1":
//                        ct = c.getCategoryID(1);
//                        break;
//                    case "2":
//                        ct = c.getCategoryID(2);
//                        break;
//                    case "3":
//                        ct = c.getCategoryID(3);
//                        break;
//                    default:
//                        ct = c.getCategoryID(4);
//                        break;
//                }
////                int priceT = Integer.parseInt(priceTo);
//                product p1 = new product(0, "", "", priceP, 0, ct);
//                List<product> list1 = c.getAllByFromToPRICEwithTID(p1, priceT);
////                request.setAttribute("s", s1);
//                List<product> list2 = c.ChangeMoney(list1);
//                session.setAttribute("datas", list2);
//                request.getRequestDispatcher("search.jsp").forward(request, response);
//
//            }
            if (choice.equals("0") && choice1.equals("0")
                    && price.equals("")  && !nameP.equals("")) {
                List<product> list1 = c.getAll1();
                List<product> list2 = new ArrayList<>();
//                request.setAttribute("s", s1);
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getTitle().contains(nameP)) {
                        list2.add(list1.get(i));
                    }
                }
                List<product> list3 = c.ChangeMoney(list2);
                session.setAttribute("datas", list3);
                request.getRequestDispatcher("search.jsp").forward(request, response);

            }
//            if ((!choice.equals("0") || !choice1.equals("0")
//                    || !price.equals("") || !priceTo.equals("")) && !nameP.equals("")) {
//                product p1 = new product(0, "", nameP, 0, 0, new category());
//                request.setAttribute("s", s1);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
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
