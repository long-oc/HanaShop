/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import dao.ProductDAO;
import dto.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Long
 */
@WebServlet(name = "ProductWithFilterController", urlPatterns = {"/ProductWithFilterController"})
public class ProductWithFilterController extends HttpServlet {

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
        response.setContentType("application/json");
        try {
            String cate = request.getParameter("cateID");
            String page_index = request.getParameter("page_index");
            String price = request.getParameter("price");
            String searchKey = request.getParameter("searchKey");
            if (searchKey == null) {
                searchKey = "";
            }
            ProductDAO productDAO = new ProductDAO();
            ArrayList<ProductDTO> product = new ArrayList<>();
            if ("0".equals(price) && searchKey != "") {
                product = productDAO.getProductSearchWithOutPrice(Integer.valueOf(page_index), Integer.valueOf(cate), searchKey);
                String json = new Gson().toJson(product);
                response.getWriter().write(json);
            } else if ("0".equals(price)) {
                product = productDAO.getMoreProductWithCate(Integer.valueOf(page_index), Integer.parseInt(cate));
                String json = new Gson().toJson(product);
                response.getWriter().write(json);
            } else {
                product = productDAO.getProductWithFilter(Integer.valueOf(page_index), Integer.valueOf(cate), Float.parseFloat(price), searchKey);
                String json = new Gson().toJson(product);
                response.getWriter().write(json);
            }
        } catch (Exception e) {
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
