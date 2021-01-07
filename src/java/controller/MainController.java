/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Long
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
private static final String LOGIN = "login.jsp";
    private static final String HOME = "home.jsp";
    private static final String REGISTER = "register.jsp";
    private static final String LOGIN_FORM = "LoginController";
    private static final String REGISTER_FORM = "RegisterController";
    private static final String BOOKING = "booking.jsp";
    private static final String SEARCH = "SearchController";
    private static final String SEARCH_FORM = "SearchFormController";
    private static final String ADD = "AddController";
    private static final String DELETE = "DeleteController";
    private static final String PAYMENT = "PaymentController";

    private static final String DETAL = "DetailController";
    private static final String ERROR = "invalid.html";
    private static final String LOGOUT = "LogoutController";
    private static final String BUY = "checkout.jsp";
    private static final String MYODER = "MyOderController";
    private static final String DELETE_ROOM = "DeleteRoomController";
    private static final String UPDATE_ROOM = "UpdateRoomController";
    private static final String ADD_ROOM = "AddRoomController";
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
        try {
            String action = request.getParameter("action");
             if ("register".equals(action)) {
                url = REGISTER;
            } else if ("loginForm".equals(action)) {
                url = LOGIN_FORM;
            } else if ("login".equals(action)){
                url=LOGIN;
            }
        } catch (Exception e) {
           
        }finally{
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
