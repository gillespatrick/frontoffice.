/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gillios
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String idAsString = request.getParameter("identifiant");
       long idAsLong = Long.parseLong(idAsString);
       
       ShoppingCart cart = (ShoppingCart)request.getSession().getAttribute("cart");
       if(cart == null){
           cart = new ShoppingCart();
           request.getSession().setAttribute("cart", cart);
       }
       
       /*for(Work work : Catalogue.listOfWork){
           if(work.getId() == idAsLong){
               cart.getItems().add(work);
           }
       }*/
       
       Optional<Work> optionalWork = Catalogue.listOfWork.stream().filter(work -> work.getId() == idAsLong).findAny();
       if(optionalWork.isPresent()){
            cart.getItems().add(optionalWork.get());
            }
       
        PrintWriter out = response.getWriter();
        out.print("<a href=\"catalogue\" >Retour au catalogue </a>");
        
        
        
        out.print("</body> </html>");
    
    }

    

}
