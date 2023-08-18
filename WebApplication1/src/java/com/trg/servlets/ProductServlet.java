/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trg.servlets;

import com.trg.dao.ProductDao;
import com.trg.entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oracle
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/products"})
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    ProductDao dao;
    
    public void init(){
        dao = new ProductDao();
    }
    
    public void destroy(){
        dao.close();
        //dao = null;
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //ProductDao dao = new ProductDao();
        
        String temp = request.getParameter("pid");
        int prodID = Integer.parseInt(temp);
        
        Product p = dao.getProduct(prodID);
          
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PrductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if(p == null){
                out.println("<h1>Product with id "+prodID+" not found </h1>");
                out.println("<a href = 'index.html'> Go Back</a>");
            }
            else{
                
                out.println("<h1>  "+p.toString()+"</h1>");
                //out.println("<h1> Product ID : "+p.getProductId()+"</h1>");
                //out.println("<h1> Name : "+p.getName()+"</h1>");
                //out.println("<h1> Price : "+p.getPrice()+"</h1>");
                out.println("<a href = 'index.html'> Go Back</a>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

}
