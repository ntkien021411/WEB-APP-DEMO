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
import modal.category;
import modal.product;

/**
 *
 * @author asus
 */
@WebServlet(name = "addProduct", urlPatterns = {"/add"})
public class addProduct extends HttpServlet {

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
            out.println("<title>Servlet addProduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProduct at " + request.getContextPath() + "</h1>");
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
        String title = request.getParameter("title");
        String price_raw = request.getParameter("price");
        String change = request.getParameter("trans");
        String change1 = request.getParameter("trans1");
        int quantity = 1;
//        String s1 = request.getParameter("dt");
        productDAO c = new productDAO();
        int id;
        List<product> list = c.getAll();
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }
        int price;
        int num = Integer.parseInt(change);
        List<product> list3 = c.getAll2(num);
        List<product> list2 = c.ChangeMoney(list3);

        try {

            HttpSession session = request.getSession();
            String name = (String) session.getAttribute("username");
            price = Integer.parseInt(price_raw);
            product p = c.checkDuplicate(img, name);
            accountDAO ac = new accountDAO();
            account acc = ac.getDuplicateAccountUser(name);
            List<product> list1 = c.ChangeMoney(c.getProductByName(name));

            if (name != null) {
                if (acc.getRole() == 0) {
//                if (acc.getRole() != 1) {
                    if (p == null) {
                        int length = list1.size() + 1;
                        request.setAttribute("length", length);
                        request.setAttribute("data1", list1);
//                    List<product> list1 = c.getProductByName(name);
//                    int length = list1.size() + 1;
//                response.sendRedirect("managemodal");
                        if (!change1.equals("5")) {
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
                                category c1 = c.getCategoryID(4);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product4.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
                                category c1 = c.getCategoryID(3);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product3.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
                                category c1 = c.getCategoryID(1);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product1.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {
                                category c1 = c.getCategoryID(2);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product2.jsp").forward(request, response);
                            }
                        } else {

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
                                category c1 = c.getCategoryID(4);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
                                category c1 = c.getCategoryID(3);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
                                category c1 = c.getCategoryID(1);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {
                                category c1 = c.getCategoryID(2);
                                product p1 = new product(id, img, title, price, quantity, c1, name);
                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }

                        }
                    } else {
                        int length = list1.size();
                        request.setAttribute("length", length);
                        request.setAttribute("data1", list1);
                        if (!change1.equals("5")) {
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
                                category c1 = c.getCategoryID(4);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product4.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
                                category c1 = c.getCategoryID(3);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product3.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
                                category c1 = c.getCategoryID(1);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product1.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {

                                category c1 = c.getCategoryID(2);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product2.jsp").forward(request, response);
                            }
                        } else {
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
                                category c1 = c.getCategoryID(4);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
                                category c1 = c.getCategoryID(3);
                                product p1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
                                category c1 = c.getCategoryID(1);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {
                                category c1 = c.getCategoryID(2);
                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }

                        }

                    }
                } else {
                   if (p == null) {
//                    List<product> list1 = c.getProductByName(name);
//                    int length = list1.size() + 1;
//                response.sendRedirect("managemodal");
                        if (!change1.equals("5")) {
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
//                                category c1 = c.getCategoryID(4);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product4.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
//                                category c1 = c.getCategoryID(3);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product3.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
//                                category c1 = c.getCategoryID(1);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product1.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {
//                                category c1 = c.getCategoryID(2);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product2.jsp").forward(request, response);
                            }
                        } else {

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
//                                category c1 = c.getCategoryID(4);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
//                                category c1 = c.getCategoryID(3);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
//                                category c1 = c.getCategoryID(1);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {
//                                category c1 = c.getCategoryID(2);
//                                product p1 = new product(id, img, title, price, quantity, c1, name);
//                                c.addDataTable(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }

                        }
                    } else {
                        
                        if (!change1.equals("5")) {
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
//                                category c1 = c.getCategoryID(4);
//                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(ct1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product4.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
//                                category c1 = c.getCategoryID(3);
//                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product3.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {
//                                category c1 = c.getCategoryID(1);
//                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product1.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {

//                                category c1 = c.getCategoryID(2);
//                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(ct1);
//                                request.setAttribute("s", s1);
                                request.setAttribute("data", list2);
                                request.getRequestDispatcher("product2.jsp").forward(request, response);
                            }
                        } else {
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
//                                category c1 = c.getCategoryID(4);
//                                product ct1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(ct1);

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("3")) {
//                                category c1 = c.getCategoryID(3);
//                                product p1 = new product(id, img, title, price, p.getQuantity() + 1, c1, name);
//                                c.update(p1);
//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("1")) {

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }
                            if (change_raw.equalsIgnoreCase("2")) {

//                                request.setAttribute("s", s1);
                                request.getRequestDispatcher("search.jsp").forward(request, response);
                            }

                        }

                    } 

                }
//                } 
//            else {
//                    change += "";
//                    String change_raw = "";
//                    if (change.equals("4")) {
//
//                        change_raw = "4";
//                    }
//                    if (change.equals("3")) {
//
//                        change_raw = "3";
//                    }
//                    if (change.equals("1")) {
//
//                        change_raw = "1";
//                    }
//                    if (change.equals("2")) {
//                        change_raw = "2";
//                    }
//                    if (change_raw.equalsIgnoreCase("4")) {
//                        request.setAttribute("data", list2);
//                        request.getRequestDispatcher("product4.jsp").forward(request, response);
//                    }
//                    if (change_raw.equalsIgnoreCase("3")) {
//                        request.setAttribute("data", list2);
//                        request.getRequestDispatcher("product3.jsp").forward(request, response);
//
//                    }
//                    if (change_raw.equalsIgnoreCase("1")) {
//                        request.setAttribute("data", list2);
//                        request.getRequestDispatcher("product1.jsp").forward(request, response);
//                    }
//                    if (change_raw.equalsIgnoreCase("2")) {
//                        request.setAttribute("data", list2);
//                        request.getRequestDispatcher("product2.jsp").forward(request, response);
//                    }
//                }

            } else {
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
                    request.setAttribute("data", list2);
                    request.getRequestDispatcher("product4.jsp").forward(request, response);
                }
                if (change_raw.equalsIgnoreCase("3")) {
                    request.setAttribute("data", list2);
                    request.getRequestDispatcher("product3.jsp").forward(request, response);

                }
                if (change_raw.equalsIgnoreCase("1")) {
                    request.setAttribute("data", list2);
                    request.getRequestDispatcher("product1.jsp").forward(request, response);
                }
                if (change_raw.equalsIgnoreCase("2")) {
                    request.setAttribute("data", list2);
                    request.getRequestDispatcher("product2.jsp").forward(request, response);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
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
