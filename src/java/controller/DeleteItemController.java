/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.CartDTO;
import dto.Purchased;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Long
 */
@WebServlet(name = "DeleteItemController", urlPatterns = {"/DeleteItemController"})
public class DeleteItemController extends HttpServlet {

    private static final String ERROR = "invalid.html";
    private static final String SUCCESS = "Oder.jsp";
    private static final String HOME = "home.jsp";
    private static final String LOGIN = "login.html";

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
        
        String url = ERROR;
        String errorMess = "";
        try {
            HttpSession session = request.getSession();
            UserDTO User = (UserDTO) session.getAttribute("USER");
            if (User != null) {
                if (User.getRoleID() == 1) {

                    String id = request.getParameter("idDel");
                    if (id == null) {
                        url = ERROR;
                    } else {
                        CartDTO cart = (CartDTO) session.getAttribute("CART");
                        if (cart == null ) {
                            url = HOME;
                        } else {
                            if ( cart.getCart().values() == null) {

                            } else {
                                for (Purchased value : cart.getCart().values()) {
                                    if (value.getId() == Integer.parseInt(id)) {
                                        if (!value.isStatus()) {
                                            url = SUCCESS;
                                            errorMess = "Sorry Item: " + value.getName() + " Not Available";
                                        } else {

                                            cart.getCart().remove(value.getId());

                                            if (cart.getCart().isEmpty()) {
                                                url = HOME;
                                            } else {
                                                url = SUCCESS;
                                            }
                                        }
                                    } else {
                                        url = SUCCESS;
                                        errorMess = "Sorry Item Your Delete Not Available";
                                    }
                                }
                            }

                        }
                    }

                } else {
                    url = LOGIN;
                }
            } else {
                url = LOGIN;
            }

        } catch (Exception e) {
        } finally {
            if (errorMess != "") {
                request.setAttribute("DELETEITEMFAIL", errorMess);
            }
            
            request.getRequestDispatcher(url).forward(request, response);
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
        processRequest(request, response);
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
