/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.CartDTO;
import dto.ProductDTO;
import dto.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RemoveItemController", urlPatterns = {"/RemoveItemController"})
public class RemoveItemController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final static String ERROR = "invalid.html";
    private final static String HOME = "home.jsp";
    private final static String ORDER = "Oder.jsp";
    private final static String LOGIN = "login.html";

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
        HttpSession session = request.getSession();
        String errorAdd = "";
        String url = ERROR;
        try {
            String idRemove = request.getParameter("idRemove");
            if (idRemove == null) {
                url = HOME;
            } else {
                UserDTO userDTO = (UserDTO) session.getAttribute("USER");
                if (userDTO == null) {
                    url = LOGIN;
                } else {
                    if (userDTO.getRoleID() == 2) {
                        url = LOGIN;
                    } else {
                        CartDTO cartDTO = (CartDTO) session.getAttribute("CART");
                        if (cartDTO == null) {
                            url = HOME;
                        } else {
                            if (cartDTO.getCart().isEmpty()) {
                                url = HOME;
                            } else {
                                if (!cartDTO.getCart().containsKey(Integer.parseInt(idRemove))) {
                                    url = HOME;
                                } else {
                                    if (!cartDTO.getCart().get(Integer.parseInt(idRemove)).isStatus()) {
                                        url = HOME;
                                    } else {
                                        ProductDAO productDAO = new ProductDAO();
                                        ProductDTO productDTO = productDAO.getProductByID(Integer.parseInt(idRemove));
                                        if (productDTO == null) {
                                            url = HOME;
                                        } else {

                                            if (cartDTO.getCart().get(Integer.parseInt(idRemove)).getQuantity() <= 0) {
                                                url = HOME;
                                            } else {
                                                cartDTO.getCart().get(Integer.parseInt(idRemove)).setQuantity(cartDTO.getCart().get(Integer.parseInt(idRemove)).getQuantity() - 1);
                                                if (cartDTO.getCart().get(Integer.parseInt(idRemove)).getQuantity() <= 0) {
                                                    cartDTO.getCart().remove(Integer.parseInt(idRemove));
                                                    if (cartDTO.getCart().isEmpty()) {
                                                        url = HOME;
                                                    } else {
                                                        url = ORDER;
                                                    }
                                                } else {

                                                    url = ORDER;

                                                }

                                            }

                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
        } finally {
            if (errorAdd != "") {
                request.setAttribute("ERRORADD", errorAdd);
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
