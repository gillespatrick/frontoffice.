<%-- 
    Document   : work-details
    Created on : Mar 13, 2021, 8:09:57 PM
    Author     : gillios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Work Details</title>
    </head>
    <body>
       
        <h1>Descriptif de l'oeuvre </h1> <br/><br/>

        Titre : ${work.Title} <br/>
        Annee de parution : ${work.Release} <br/>
        Genre : ${work.Genre } <br/>
        Artiste : ${work.mainArtist.name} <br/>
        Resume : ${work.Summary} <br/>
        
        <form action=\addToCart" method="POST">
            <input type="hidden" name="identifiant" value="" ${work.id} />
            <input type=\"submit\" value="Ajouter au caddie" />

        </form>
    
</body>
</html>
