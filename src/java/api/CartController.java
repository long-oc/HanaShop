/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import dao.ProductDAO;
import dto.CartDTO;
import dto.ProductDTO;
import dto.Purchased;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "CartController", urlPatterns = {"/CartController"})
public class CartController extends HttpServlet {

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
        CartDTO cartDTO = null;
        try {
            HttpSession session = request.getSession();
            ProductDAO productDAO = new ProductDAO();
            Purchased purchased = new Purchased();
            cartDTO = new CartDTO();
            cartDTO = (CartDTO) session.getAttribute("CART");
            if (cartDTO == null) {
                cartDTO = new CartDTO("", new HashMap<>());
            }
            ProductDTO productDTO = new ProductDTO();
            String id = request.getParameter("addID");
            productDTO = productDAO.getProductByID(Integer.parseInt(id));
            if (productDTO == null || productDTO.isStatus() == false) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } else {
                int quantiyOfProductID = 0;
                for (Map.Entry<Integer, Purchased> entry : cartDTO.getCart().entrySet()) {
                    Integer key = entry.getKey();
                    Purchased value = entry.getValue();
                    if (key == Integer.parseInt(id)) {
                        quantiyOfProductID = value.getQuantity();
                    }
                }

                if (productDTO.getQuantity() - quantiyOfProductID <= 0) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                } else {
                    purchased = new Purchased(productDTO.getProductID(), productDTO.getProductName(), productDTO.getProductPrice(), 1, productDTO.getImage(),productDTO.isStatus());
                    if (cartDTO.add(purchased)) {
                        String json = new Gson().toJson(cartDTO.getCart().values());
                        response.getWriter().write(json);
                        session.setAttribute("CART", cartDTO);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    }
                }
            }

        } catch (Exception e) {
        } finally {

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
