/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.ProductAdminDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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
@WebServlet(name = "UpdateAdController", urlPatterns = {"/UpdateAdController"})
public class UpdateAdController extends HttpServlet {

    private static final String ERROR = "invalid.html";
    private static final String SUCCESS = "AdminController";
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
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String url = ERROR;
        String errorUpdateAD = "";
        try {
            UserDTO userDTO = (UserDTO) session.getAttribute("USER");
            if (userDTO == null) {
                url = LOGIN;
            } else {
                if (userDTO.getRoleID() != 2) {
                    url = LOGIN;
                } else {
                    String txtProductID = request.getParameter("txtProductID");
                    String txtProductName = request.getParameter("txtProductName");
                    String decoded = URLDecoder.decode(txtProductName, "UTF-8");
                    String txtPrice = request.getParameter("txtPrice");
                    String txtMadeIn = request.getParameter("txtMadeIn");
                    String txtImage = request.getParameter("txtImage");
                    String txtDecription = request.getParameter("txtDecription");
                    String txtQuantity = request.getParameter("txtQuantity");
                    String CateAD = request.getParameter("CateAD");
                    String status = request.getParameter("status");
                    if (txtProductID == null || txtProductName == null || txtPrice == null || txtMadeIn == null || txtImage == null || txtDecription == null || txtQuantity == null || CateAD == null || status == null) {
                        url = ERROR;
                    } else if (txtProductID == "" || txtProductName == "" || txtPrice == "" || txtMadeIn == "" || txtImage == "" || txtDecription == "" || txtQuantity == "" || CateAD == "" || status == "") {
                        url = SUCCESS;
                        errorUpdateAD = "Please Don't Empty";
                    } else {
                        ProductDAO productDAO = new ProductDAO();
                        ProductAdminDTO proUpdate = new ProductAdminDTO(Integer.parseInt(txtProductID), txtProductName, Float.parseFloat(txtPrice), txtMadeIn, txtImage, txtDecription, Integer.parseInt(txtQuantity), null, Integer.parseInt(CateAD), null, Boolean.parseBoolean(status));
                        if (productDAO.updateItem(proUpdate)) {
                            url = SUCCESS;
                        } else {
                            url = SUCCESS;
                            errorUpdateAD = "Update Fail";
                        }
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            if (errorUpdateAD != "") {
                request.setAttribute("ERRORUPDATEAD", errorUpdateAD);
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
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
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
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
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
