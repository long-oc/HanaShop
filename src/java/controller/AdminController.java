/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dto.CateDTO;
import dto.ProductAdminDTO;
import dto.ProductDTO;
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
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    private static final String SUCCESS = "admin.jsp";
    private static final String ERROR = "invalid.html";
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

        HttpSession session = request.getSession();
        String pageIndex = "0";
        String url = ERROR;
        ArrayList<ProductAdminDTO> list = new ArrayList<>();
        ArrayList<CateDTO> listCate = new ArrayList<>();
        try {
            UserDTO udto = (UserDTO) session.getAttribute("USER");
            if (udto == null) {
                url = LOGIN;
            } else {
                if (!udto.isStatus()) {
                    url = LOGIN;
                } else {
                    if (udto.getRoleID() != 2) {
                        url = LOGIN;
                    } else {
                        ProductDAO productDAO = new ProductDAO();
                        list = (ArrayList<ProductAdminDTO>) session.getAttribute("PRODUCTAD");
                        pageIndex = (String) request.getParameter(pageIndex);
                        if (pageIndex == null) {
                            pageIndex = "1";
                        }
                        if (list == null) {
                            list = productDAO.getProductWithPageing((Integer.parseInt(pageIndex) - 1) * 10);
                            listCate=productDAO.getAllCate();
                            url=SUCCESS;
                        } else {
                            ArrayList<ProductAdminDTO> listProductGetDataBase = productDAO.getProductWithPageing((Integer.parseInt(pageIndex) - 1) * 10);
                            if (listProductGetDataBase != null) {
                                list = productDAO.getProductWithPageing((Integer.parseInt(pageIndex) - 1) * 10);
                                listCate=productDAO.getAllCate();  
                                url = SUCCESS;
                            } else {
                                url = SUCCESS;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
           
        }finally{
             if (list != null) {
                session.setAttribute("PRODUCTAD", list);
            }
             if(listCate!=null){
                 session.setAttribute("CATEAD", listCate);
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
