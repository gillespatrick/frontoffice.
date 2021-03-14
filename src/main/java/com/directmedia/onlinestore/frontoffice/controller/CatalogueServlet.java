/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.frontoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalogue;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gillios
 */
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        if (Catalogue.listOfWork.isEmpty()){
        Artist tom = new Artist("Gilles Patrick");
        Artist shak = new Artist("Amaru Shakur");
        Artist big = new Artist("Big Walace");

        Work devop = new Work("Web Developper");
        Work home = new Work("Baby don't cry");
        Work sky = new Work("Sky hasn't the limit ");

        devop.setMainArtist(tom);
        home.setMainArtist(shak);
        sky.setMainArtist(big);

        devop.setRelease(2016);
        home.setRelease(1995);
        sky.setRelease(2003);

        devop.setSummary("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        home.setSummary("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        sky.setSummary("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

        devop.setGenre("Development");
        home.setGenre("Hip Hop");
        sky.setGenre("Rapper");
        
        devop.setId(1);
        home.setId(2);
        sky.setId(3);

        Catalogue.listOfWork.add(devop);
        Catalogue.listOfWork.add(home);
        Catalogue.listOfWork.add(sky);

       
        }

        for (Work work : Catalogue.listOfWork) {

            out.println("<a href = \"work-details?id="+work.getId()+"\"> "+work.getTitle() +" (" + work.getRelease() +")</a> <br/>");
        }

        out.print("</body></html>");

    }

}
